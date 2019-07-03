package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.ladder.LadderGame;
import com.jaeyeonling.ladder.domain.ladder.LadderRewords;
import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.line.Lines;
import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Users;

import java.util.List;

public interface Fixture {
    String rawUsername = "test";
    String rawUsers = "test1,test2,test3,test4,test5";

    User user = User.of(rawUsername);
    Users multiUsers = Users.ofSeparator(rawUsers);
    CountOfUsers countOfusers = multiUsers.getCountOfUsers();

    List<Direction> rightLeftDirection = List.of(Direction.RIGHT, Direction.LEFT,
            Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);
    List<Direction> straightDirection = List.of(Direction.STRAIGHT, Direction.STRAIGHT,
            Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT);

    Line rightLeftLine = Line.ofDirections(rightLeftDirection);
    Line allStraightLine = Line.ofDirections(straightDirection);

    List<Line> rawAllRightLeftLines = List.of(rightLeftLine, rightLeftLine, rightLeftLine,
            rightLeftLine, rightLeftLine);
    List<Line> rawAllStraightLines = List.of(allStraightLine, allStraightLine, allStraightLine,
            allStraightLine, allStraightLine);

    String rawLadderRewords = "꽝,5000,꽝,5000,꽝";

    LadderRewords LADDER_REWORDS = LadderRewords.ofSeparator(rawLadderRewords);

    Lines allRightLeftLines = Lines.of(rawAllRightLeftLines);
    Lines allStraightLines = Lines.of(rawAllStraightLines);

    GameInfo gameInfo = GameInfo.withUsersAndLadderRewords(Fixture.multiUsers, Fixture.LADDER_REWORDS);
    LadderGame ladderGame = LadderGame.of(gameInfo, allStraightLines);
}
