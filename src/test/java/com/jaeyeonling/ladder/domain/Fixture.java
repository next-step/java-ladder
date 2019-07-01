package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.line.Line;
import com.jaeyeonling.ladder.domain.point.Direction;
import com.jaeyeonling.ladder.domain.user.CountOfUsers;
import com.jaeyeonling.ladder.domain.user.User;
import com.jaeyeonling.ladder.domain.user.Username;
import com.jaeyeonling.ladder.domain.user.Users;

import java.util.List;

public interface Fixture {
    String rawUsername = "test";
    String rawUsers = "test1,test2,test3,test4,test5";

    Username username = Username.valueOf(rawUsername);
    User user = User.of(rawUsername);
    Users signleUsers = Users.ofSeparator(rawUsername);
    Users multiUsers = Users.ofSeparator(rawUsers);
    CountOfUsers countOfusers = multiUsers.getCountOfUsers();

    List<Direction> allConnectDirection = List.of(Direction.RIGHT, Direction.LEFT,
            Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT);
    List<Direction> allNotConnectDirection = List.of(Direction.STRAIGHT, Direction.STRAIGHT,
            Direction.STRAIGHT, Direction.STRAIGHT, Direction.STRAIGHT);

    Line allTrueLine = Line.ofDirections(allConnectDirection);
    Line allFalseLine = Line.ofDirections(allNotConnectDirection);
}
