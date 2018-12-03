package ladder.domain

val POSITION_ONE = listOf(Point(0, Direction.first(true)),
        Point(1, Direction.of(true, false)),
        Point(2, Direction.of(false, false)))

val POSITION_TWO = listOf(Point(0, Direction.first(false)),
        Point(1, Direction.of(false, true)),
        Point(2, Direction.of(true, false)))

val POSITION_THREE = listOf(Point(0, Direction.first(false)),
        Point(1, Direction.of(false, false)),
        Point(2, Direction.of(false, false)))

val PLAYERS = arrayListOf(Player("Dave"), Player("Lee"), Player("Kim"))
val LINES = arrayListOf(Line(POSITION_ONE), Line(POSITION_TWO), Line(POSITION_THREE))
val LADDER = Ladder(PLAYERS, LINES)

val REWARDS = Rewards("꽝,1000,꽝")

val PLAYER_POSITIONS = PlayerPositions(PLAYERS, LADDER)