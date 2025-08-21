package com.velaphi.pokemons.network

import com.velaphi.pokemons.network.constants.NetworkConstants
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.HttpURLConnection

class NetworkErrorHandlerTest {

    @Test
    fun `handleException with UnknownHostException returns no internet connection message`() = runTest {
        // Given
        val unknownHostException = UnknownHostException("Unable to resolve host")

        // When
        val result = NetworkErrorHandler.handleException(unknownHostException)

        // Then
        assertEquals(NetworkConstants.NO_INTERNET_CONNECTION, result)
    }

    @Test
    fun `handleException with ConnectException returns no internet connection message`() = runTest {
        // Given
        val connectException = ConnectException("Connection refused")

        // When
        val result = NetworkErrorHandler.handleException(connectException)

        // Then
        assertEquals(NetworkConstants.NO_INTERNET_CONNECTION, result)
    }

    @Test
    fun `handleException with SocketTimeoutException returns request timed out message`() = runTest {
        // Given
        val socketTimeoutException = SocketTimeoutException("Read timed out")

        // When
        val result = NetworkErrorHandler.handleException(socketTimeoutException)

        // Then
        assertEquals(NetworkConstants.REQUEST_TIMED_OUT, result)
    }

    @Test
    fun `handleException with IOException returns network error message`() = runTest {
        // Given
        val ioException = IOException("Network error occurred")

        // When
        val result = NetworkErrorHandler.handleException(ioException)

        // Then
        assertTrue(result.contains("Network error occurred"))
    }

    @Test
    fun `handleException with generic exception returns unexpected error message`() = runTest {
        // Given
        val genericException = Exception("Something went wrong")

        // When
        val result = NetworkErrorHandler.handleException(genericException)

        // Then
        assertTrue(result.contains("Something went wrong"))
    }

    @Test
    fun `handleHttpException with 401 returns authentication failed message`() = runTest {
        // Given
        val httpException = HttpException(retrofit2.Response.error<Any>(
            HttpURLConnection.HTTP_UNAUTHORIZED,
            okhttp3.ResponseBody.create(null, "Unauthorized")
        ))

        // When
        val result = NetworkErrorHandler.handleException(httpException)

        // Then
        assertTrue(result.contains("401"))
        assertTrue(result.contains("Authentication failed"))
    }

    @Test
    fun `handleHttpException with 403 returns access denied message`() = runTest {
        // Given
        val httpException = HttpException(retrofit2.Response.error<Any>(
            HttpURLConnection.HTTP_FORBIDDEN,
            okhttp3.ResponseBody.create(null, "Forbidden")
        ))

        // When
        val result = NetworkErrorHandler.handleException(httpException)

        // Then
        assertTrue(result.contains("403"))
        assertTrue(result.contains("Access denied"))
    }

    @Test
    fun `handleHttpException with 404 returns not found message`() = runTest {
        // Given
        val httpException = HttpException(retrofit2.Response.error<Any>(
            HttpURLConnection.HTTP_NOT_FOUND,
            okhttp3.ResponseBody.create(null, "Not Found")
        ))

        // When
        val result = NetworkErrorHandler.handleException(httpException)

        // Then
        assertTrue(result.contains("404"))
        assertTrue(result.contains("Resource not found"))
    }

    @Test
    fun `handleHttpException with 503 returns service unavailable message`() = runTest {
        // Given
        val httpException = HttpException(retrofit2.Response.error<Any>(
            HttpURLConnection.HTTP_UNAVAILABLE,
            okhttp3.ResponseBody.create(null, "Service Unavailable")
        ))

        // When
        val result = NetworkErrorHandler.handleException(httpException)

        // Then
        assertTrue(result.contains("503"))
        assertTrue(result.contains("Service temporarily unavailable"))
    }
}
