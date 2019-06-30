package com.jaeyeonling.ladder.domain;

import com.jaeyeonling.ladder.domain.line.Line;
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

    List<Boolean> allFalsePoint = List.of(false, false, false, false, false);
    List<Boolean> allTruePoint = List.of(false, true, false, true, false);

    Line allFalseLine = Line.ofPoints(allFalsePoint);
    Line allTrueLine = Line.ofPoints(allTruePoint);
}
