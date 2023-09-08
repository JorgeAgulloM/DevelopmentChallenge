package com.softyorch.retosdeprogramacion.challenges

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CheckFridayTest {

    @RelaxedMockK
    private lateinit var knowIfFridayThe13ThImpl: IKnowIfFridayThe13th
    @RelaxedMockK
    private lateinit var checkFriday: CheckFriday

    private val mockIsFriday = Pair(10, 2023)
    private val mockNotFriday = Pair(5, 1999)

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        checkFriday = CheckFriday(knowIfFridayThe13ThImpl)
    }

    @Test
    fun whenCallingCheckFridayThis_youMustCallKnowIfFridayThe13ThImpl() {
        //Given
        //calendar.set(mockIsFriday.first, mockIsFriday.second)
        every { knowIfFridayThe13ThImpl.isFriday(mockNotFriday.first, mockNotFriday.second) } returns false

        //When
        checkFriday.check(mockNotFriday.first, mockNotFriday.second)

        //Then
        verify(exactly = 1) { knowIfFridayThe13ThImpl.isFriday(mockNotFriday.first, mockNotFriday.second) }
    }

    @Test
    fun whenEnteringAValidDate() = runBlocking {
        //Given
        //calendar.set(mockIsFriday.first, mockIsFriday.second)
        every { knowIfFridayThe13ThImpl.isFriday(mockIsFriday.first, mockIsFriday.second) } returns true

        //When
        val result = checkFriday.check(mockIsFriday.first, mockIsFriday.second)

        //Then
        assertEquals(knowIfFridayThe13ThImpl.isFriday(mockIsFriday.first, mockIsFriday.second), result)
    }

    @Test
    fun whenEnteringAInvalidDate() {
        //Given
        //calendar.set(mockIsFriday.first, mockIsFriday.second)
        every { knowIfFridayThe13ThImpl.isFriday(mockNotFriday.first, mockNotFriday.second) } returns false

        //When
        val result = checkFriday.check(mockNotFriday.first, mockNotFriday.second)

        //Then
        assertEquals(knowIfFridayThe13ThImpl.isFriday(mockNotFriday.first, mockNotFriday.second), result)

    }
}