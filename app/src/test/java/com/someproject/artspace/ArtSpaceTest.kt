package com.someproject.artspace

import androidx.compose.runtime.neverEqualPolicy
import org.junit.Assert.assertEquals
import org.junit.Test

class ArtSpaceTest {

    @Test
    fun check_current_position_with_integer_from_previous_button(){
        assertEquals(1, previousButton(1))
        assertEquals(1, previousButton(2))
        assertEquals(2, previousButton(3))
        assertEquals(3, previousButton(4))
        assertEquals(4, previousButton(5))
    }

    @Test
    fun check_current_position_with_integer_from_next_button(){
        assertEquals(2, nextButton(1))
        assertEquals(3, nextButton(2))
        assertEquals(4, nextButton(3))
        assertEquals(5, nextButton(4))
        assertEquals(5, nextButton(5))
    }
}