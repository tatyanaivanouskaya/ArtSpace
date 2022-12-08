package com.someproject.artspace

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.someproject.artspace.ui.theme.ArtSpaceTheme
import org.junit.Rule
import org.junit.Test

class ArtSpaceUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun check_first_image_with_author_and_posted_date() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
        composeTestRule.onNodeWithText("Alin Luna").assertExists()
        composeTestRule.onNodeWithText("Posted on March 18th, 2021").assertExists()
        composeTestRule.onNodeWithContentDescription(R.drawable.pexels_alin_luna.toString())
            .assertExists()
    }

    @Test
    fun check_second_image_with_author_and_posted_date_after_click_next_button() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("Kevin Gamba").assertExists()
        composeTestRule.onNodeWithText("Posted on September 30th, 2021").assertExists()
        composeTestRule.onNodeWithContentDescription(R.drawable.pexels_kevin_gamba.toString())
            .assertExists()
    }

    @Test
    fun check_image_with_author_and_posted_date_after_click_next_button_three_times() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()

        composeTestRule.onNodeWithText("Steve Johnson").assertExists()
        composeTestRule.onNodeWithText("Posted on March 18th, 2021").assertExists()
        composeTestRule.onNodeWithContentDescription(R.drawable.pexels_steve_johnson.toString())
            .assertExists()
    }

    @Test
    fun check_image_with_author_and_posted_date_after_click_next_button_three_times_and_previous_button_two_times() {
        composeTestRule.setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }

        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Next").performClick()
        composeTestRule.onNodeWithText("Previous").performClick()
        composeTestRule.onNodeWithText("Previous").performClick()


        composeTestRule.onNodeWithText("Kevin Gamba").assertExists()
        composeTestRule.onNodeWithText("Posted on September 30th, 2021").assertExists()
        composeTestRule.onNodeWithContentDescription(R.drawable.pexels_kevin_gamba.toString())
            .assertExists()
    }
}