package com.abc.reply

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.abc.reply.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

class ReplyAppTest {

    /**
     * Note: To access to an empty activity, the code uses ComponentActivity instead of
     * MainActivity.
     */
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    @Test
    @TestCompactWidth
    fun compactDevice_verifyUsingBottomNavigation() {
        // Set up compact window
        composeTestRule.setContent {
            // Adding a composable that accepts WindowWidthSizeClass as an argument
            // is a good practice to make testable code.
            ReplyApp(windowSize = WindowWidthSizeClass.Compact)
        }

        // Bottom navigation is displayed
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_bottom).assertExists()
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_verifyUsingNavigationRail() {
        // Set up medium window
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Medium)
        }

        // Bottom navigation is displayed
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_rail).assertExists()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_verifyUsingNavigationDrawer() {
        // Set up expanded window
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
        }

        // Navigation drawer is displayed
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_drawer).assertExists()
    }
}