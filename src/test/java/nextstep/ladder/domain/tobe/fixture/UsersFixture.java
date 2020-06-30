package nextstep.ladder.domain.tobe.fixture;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.Arrays;

public class UsersFixture {
    public static Users TestUsers = new Users(
            Arrays.asList(
                    new User("pobi"),
                    new User("honux"),
                    new User("crong"),
                    new User("jk")));
}
