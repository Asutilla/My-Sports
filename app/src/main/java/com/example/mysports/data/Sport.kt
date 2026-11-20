package com.example.mysports.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Match(
    val homeTeam: String,
    val awayTeam: String,
    val homeScore: Int,
    val awayScore: Int,
    val status: String,
    val date: String
)

data class Sport(
    val id: String,
    val name: String,
    val category: String,
    val description: String,
    val rules: List<String>,
    val popularLeagues: List<String>,
    val iconName: String,
    val sampleMatches: List<Match>
)
