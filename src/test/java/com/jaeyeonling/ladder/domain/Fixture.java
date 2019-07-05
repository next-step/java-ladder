package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderRewords;
import com.jaeyeonling.ladder.domain.line.HeightOfLadder;
import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Users;

import java.util.List;

public final class Fixture {
    private Fixture() { }

    private static String rawUsername = "test";
    public static String rawUsers = "test1,test2,test3,test4,test5";

    public static User user = User.of(rawUsername);
    private static Users multiUsers = Users.ofSeparator(rawUsers);
    public static CountOfUsers countOfusers = multiUsers.getCountOfUsers();

    public static List<Direction> rightLeftDirection = List.of(Direction.RIGHT, Direction.LEFT,
            Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);
    private static List<Direction> straightDirection = List.of(Direction.STRAIGHT, Direction.STRAIGHT,
            Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT);

    public static Line rightLeftLine = Line.ofDirections(rightLeftDirection);
    public static Line allStraightLine = Line.ofDirections(straightDirection);

    public static List<Line> rawAllRightLeftLines = List.of(rightLeftLine, rightLeftLine, rightLeftLine,
            rightLeftLine, rightLeftLine);
    public static List<Line> rawAllStraightLines = List.of(allStraightLine, allStraightLine, allStraightLine,
            allStraightLine, allStraightLine);

    public static String rawLadderRewords = "꽝,5000,꽝,5000,꽝";

    private static LadderRewords LADDER_REWORDS = LadderRewords.ofSeparator(rawLadderRewords);

    public static Lines allRightLeftLines = Lines.of(rawAllRightLeftLines);
    public static Lines allStraightLines = Lines.of(rawAllStraightLines);

    public static GameInfo gameInfo = GameInfo.withUsersAndLadderRewords(Fixture.multiUsers, Fixture.LADDER_REWORDS);
    public static LadderGame ladderGame = LadderGame.of(gameInfo);
    static {
        ladderGame.initializeLines(HeightOfLadder.valueOf(5), (ignore1, ignore2) -> allStraightLines);
    }
}
