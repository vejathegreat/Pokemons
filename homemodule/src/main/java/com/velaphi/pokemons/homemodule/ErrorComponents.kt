package com.velaphi.pokemons.homemodule

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import com.velaphi.pokemons.homemodule.constants.StringConstants

/**
 * Loading content with spinner.
 */
@Composable
fun LoadingContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
    }
}

/**
 * Network error content component.
 */
@Composable
fun NetworkErrorContent(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = when {
                message.contains(StringConstants.KEYWORD_NO_INTERNET, ignoreCase = true) -> StringConstants.EMOJI_NO_INTERNET
                message.contains(StringConstants.KEYWORD_TIMEOUT, ignoreCase = true) -> StringConstants.EMOJI_TIMEOUT
                message.contains(StringConstants.KEYWORD_SERVER, ignoreCase = true) -> StringConstants.EMOJI_SERVER
                message.contains(StringConstants.KEYWORD_NETWORK, ignoreCase = true) -> StringConstants.EMOJI_NETWORK
                else -> StringConstants.EMOJI_ERROR
            },
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.size(64.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = when {
                message.contains(StringConstants.KEYWORD_NO_INTERNET, ignoreCase = true) -> stringResource(R.string.no_internet_connection)
                message.contains(StringConstants.KEYWORD_TIMEOUT, ignoreCase = true) -> stringResource(R.string.request_timed_out)
                message.contains(StringConstants.KEYWORD_SERVER, ignoreCase = true) -> stringResource(R.string.server_error)
                message.contains(StringConstants.KEYWORD_NETWORK, ignoreCase = true) -> stringResource(R.string.network_error)
                else -> stringResource(R.string.something_went_wrong)
            },
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
        
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(stringResource(R.string.retry_button))
        }

        when {
            message.contains(StringConstants.KEYWORD_NO_INTERNET, ignoreCase = true) -> {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.check_wifi_mobile),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            message.contains(StringConstants.KEYWORD_TIMEOUT, ignoreCase = true) -> {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.connection_slow),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            message.contains(StringConstants.KEYWORD_SERVER, ignoreCase = true) -> {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.server_issues),
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

/**
 * Simple error content component.
 */
@Composable
fun SimpleErrorContent(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = StringConstants.EMOJI_ERROR,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.size(64.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(onClick = onRetry) {
            Text(stringResource(R.string.retry_button))
        }
    }
}

/**
 * Empty state UI.
 */
@Composable
fun EmptyState(
    message: String = stringResource(R.string.no_content_available),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = StringConstants.EMOJI_EMPTY,
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}
