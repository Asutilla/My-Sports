package com.example.mysports.data

object SportsRepository {
    val sports = listOf(
        Sport(
            id = "football",
            name = "Football",
            category = "Team Sport",
            description = "American Football is a high-intensity team sport played on a 100-yard field with end zones, where teams advance the oval ball by running or passing.",
            rules = listOf(
                "Teams have 4 downs to gain 10 yards.",
                "Touchdown is worth 6 points, field goal is worth 3 points.",
                "11 players per team on the field."
            ),
            popularLeagues = listOf("NFL", "NCAA Football", "CFL"),
            iconName = "Football",
            sampleMatches = listOf(
                Match("Kansas City", "San Francisco", 25, 22, "Final (OT)", "Feb 11"),
                Match("Dallas", "Philadelphia", 33, 13, "Final", "Dec 10"),
                Match("Detroit", "Green Bay", 34, 20, "Final", "Nov 23")
            )
        ),
        Sport(
            id = "basketball",
            name = "Basketball",
            category = "Team Sport",
            description = "A fast-paced game played on a rectangular court where two teams of five players score points by shooting a ball through a hoop elevated 10 feet high.",
            rules = listOf(
                "Baskets inside the 3-point arc are worth 2 points, outside are 3 points.",
                "Free throws are worth 1 point each.",
                "Shot clock resets to 24 seconds on possessions."
            ),
            popularLeagues = listOf("NBA", "EuroLeague", "WNBA", "NCAA Basketball"),
            iconName = "Basketball",
            sampleMatches = listOf(
                Match("Boston", "Dallas", 106, 88, "Final", "Jun 17"),
                Match("Denver", "LA Lakers", 114, 103, "Final", "Apr 20"),
                Match("Golden State", "Miami", 113, 92, "Final", "Mar 26")
            )
        ),
        Sport(
            id = "soccer",
            name = "Soccer",
            category = "Team Sport",
            description = "Association football (soccer) is the world's most popular sport, played between two teams of eleven players using a spherical ball on a rectangular pitch with goals at each end.",
            rules = listOf(
                "Match consists of two 45-minute halves.",
                "Hands cannot be used except by the goalkeeper within penalty area.",
                "Offside rule prevents cherry-picking behind defense."
            ),
            popularLeagues = listOf("UEFA Champions League", "Premier League", "La Liga", "MLS"),
            iconName = "Soccer",
            sampleMatches = listOf(
                Match("Real Madrid", "Borussia Dortmund", 2, 0, "Final", "Jun 1"),
                Match("Manchester City", "Arsenal", 0, 0, "Final", "Mar 31"),
                Match("Inter Miami", "LA Galaxy", 1, 1, "Final", "Feb 25")
            )
        ),
        Sport(
            id = "tennis",
            name = "Tennis",
            category = "Racket Sport",
            description = "A racket sport played individually against a single opponent (singles) or between two teams of two players each (doubles), hitting a felt-covered rubber ball over a net.",
            rules = listOf(
                "Scoring sequence: 15, 30, 40, Game.",
                "Must win by 2 points (Deuce rule).",
                "Matches played as best of 3 or best of 5 sets."
            ),
            popularLeagues = listOf("Wimbledon", "US Open", "Roland Garros", "Australian Open"),
            iconName = "Tennis",
            sampleMatches = listOf(
                Match("Alcaraz", "Djokovic", 3, 2, "Final", "Jul 14"),
                Match("Sinner", "Medvedev", 3, 2, "Final", "Jan 28"),
                Match("Swiatek", "Paolini", 2, 0, "Final", "Jun 8")
            )
        ),
        Sport(
            id = "baseball",
            name = "Baseball",
            category = "Team Sport",
            description = "A bat-and-ball game played between two opposing teams who take turns batting and fielding, scoring runs by hitting a pitched ball and running counter-clockwise around four bases.",
            rules = listOf(
                "9 innings per standard game.",
                "3 outs per half-inning for each team.",
                "3 strikes result in a strikeout, 4 balls result in a walk."
            ),
            popularLeagues = listOf("MLB", "NPB", "KBO League"),
            iconName = "Baseball",
            sampleMatches = listOf(
                Match("Texas", "Arizona", 5, 0, "Final", "Nov 1"),
                Match("NY Yankees", "LA Dodgers", 6, 4, "Final", "Oct 29"),
                Match("Houston", "Atlanta", 3, 2, "Final", "Sep 15")
            )
        ),
        Sport(
            id = "volleyball",
            name = "Volleyball",
            category = "Team Sport",
            description = "A team sport in which two teams of six players are separated by a net, using their hands to hit a ball back and forth over the net trying to make it touch the opponent's court.",
            rules = listOf(
                "Maximum 3 touches per side before returning ball.",
                "First team to reach 25 points wins a set (must lead by 2).",
                "Best of 5 sets per match."
            ),
            popularLeagues = listOf("FIVB Nations League", "CEV Champions League", "V.League"),
            iconName = "Volleyball",
            sampleMatches = listOf(
                Match("France", "Poland", 3, 0, "Final", "Aug 10"),
                Match("Italy", "USA", 3, 1, "Final", "Aug 9"),
                Match("Brazil", "Japan", 3, 2, "Final", "Jul 20")
            )
        )
    )

    fun getSportById(id: String): Sport? {
        return sports.find { it.id.equals(id, ignoreCase = true) }
    }
}
