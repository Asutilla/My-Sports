package com.example.mysports

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.mysports.ui.MainScreen
import com.example.mysports.ui.theme.MySportsTheme
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verifyHomeScreenDisplayedByDefault() {
        composeTestRule.setContent {
            MySportsTheme {
                MainScreen()
            }
        }

        composeTestRule.onNodeWithText("Welcome to My Sports!").assertIsDisplayed()
    }

    @Test
    fun verifyBottomNavigationDestinations() {
        composeTestRule.setContent {
            MySportsTheme {
                MainScreen()
            }
        }

        // Click Account tab
        composeTestRule.onNodeWithText("Account").performClick()
        composeTestRule.onNodeWithText("Account Settings").assertIsDisplayed()

        // Click Profile tab
        composeTestRule.onNodeWithText("Profile").performClick()
        composeTestRule.onNodeWithText("User Profile").assertIsDisplayed()

        // Click My Sports tab
        composeTestRule.onNodeWithText("My Sports").performClick()
        composeTestRule.onNodeWithText("Football").assertIsDisplayed()
    }

    @Test
    fun verifySecondarySportDetailNavigationAndBack() {
        composeTestRule.setContent {
            MySportsTheme {
                MainScreen()
            }
        }

        // Navigate to My Sports
        composeTestRule.onNodeWithText("My Sports").performClick()

        // Click Football card to navigate to Football detail
        composeTestRule.onNodeWithText("Football").performClick()

        // Check key rules section in Football Detail
        composeTestRule.onNodeWithText("Key Rules").assertIsDisplayed()

        // Click Back button in top bar
        composeTestRule.onNodeWithContentDescription("Back").performClick()

        // Verify back on My Sports screen
        composeTestRule.onNodeWithText("Football").assertIsDisplayed()
    }
}
