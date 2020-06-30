package nextstep.ladder.domain.fixture;

import nextstep.ladder.domain.users.User;
import nextstep.ladder.domain.users.Users;

import java.util.Arrays;

public class UsersFixture {
    public static Users TestUsers = new Users(
            Arrays.asList(
                    new User("pobi"),
                    new User("honux"),
                    new User("crong"),
                    new User("jk")));
}
