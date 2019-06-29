package com.jaeyeonling.ladder;

import java.util.List;

public interface Fixture {
    String rawUsername = "test";
    String rawUsers = "test1,test2,test3,test4,test5";

    Username username = Username.of(rawUsername);
    User user = User.of(rawUsername);
    Users signleUsers = Users.of(rawUsername);
    Users multiUsers = Users.of(rawUsers);
    CountOfUsers countOfusers = multiUsers.getCountOfUsers();

    List<Boolean> allFalsePoint = List.of(false, false, false, false, false);
    Line allFalseLine = Line.of(allFalsePoint);
}
