package com.example.mysports

import com.example.mysports.data.SportsRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SportsRepositoryTest {

    @Test
    fun sportsList_isNotEmpy() {
        val sports = SportsRepository.sports
        assertTrue(sports.isNotEmpty())
    }

    @Test
    fun getSportById_returnsCorrectSport() {
        val football = SportsRepository.getSportById("football")
        assertNotNull(football)
        assertEquals("Football", football?.name)
        assertEquals("Team Sport", football?.category)
    }

    @Test
    fun getSportById_caseInsensitive() {
        val basketball = SportsRepository.getSportById("BASKETBALL")
        assertNotNull(basketball)
        assertEquals("Basketball", basketball?.name)
    }

    @Test
    fun getSportById_invalidId_returnsNull() {
        val invalid = SportsRepository.getSportById("non_existent_sport")
        assertNull(invalid)
    }
}
