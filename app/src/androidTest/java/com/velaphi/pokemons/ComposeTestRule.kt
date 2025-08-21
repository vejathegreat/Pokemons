package com.velaphi.pokemons

import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ComposeTestRule {

    @get:Rule
    val composeTestRule: ComposeContentTestRule = createComposeRule()

    @Test
    fun testComposeRuleCreation() {
        // This test verifies that the Compose test rule is working correctly
        composeTestRule.setContent {
            // Empty content for basic test
        }
        
        // If we reach here, the rule is working
        assert(true)
    }

    @Test
    fun testComposeRuleWithContent() {
        composeTestRule.setContent {
            androidx.compose.material3.Text("Test Content")
        }
        
        // Verify the text is displayed
        composeTestRule.onNodeWithText("Test Content").assertIsDisplayed()
    }

    @Test
    fun testComposeRuleTextAssertion() {
        composeTestRule.setContent {
            androidx.compose.material3.Text("Expected Text")
        }
        
        // Verify the exact text content
        composeTestRule.onNodeWithText("Expected Text").assertTextEquals("Expected Text")
    }

    @Test
    fun testComposeRuleClickInteraction() {
        var clicked = false
        
        composeTestRule.setContent {
            androidx.compose.material3.Button(
                onClick = { clicked = true }
            ) {
                androidx.compose.material3.Text("Click Me")
            }
        }
        
        // Perform click
        composeTestRule.onNodeWithText("Click Me").performClick()
        
        // Verify click was registered
        assert(clicked)
    }

    @Test
    fun testComposeRuleTextInput() {
        var text = ""
        
        composeTestRule.setContent {
            androidx.compose.material3.OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { androidx.compose.material3.Text("Input Label") }
            )
        }
        
        // Input text
        composeTestRule.onNodeWithText("Input Label").performTextInput("Test Input")
        
        // Verify text was input
        assert(text == "Test Input")
    }
}
