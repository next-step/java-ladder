package nextstep.ladder.view;

import nextstep.ladder.domain.User;
import nextstep.ladder.domain.Users;

import java.util.ArrayList;
import java.util.List;

public class UsersRaw {
    public static Users createUsers(String usersRaw) {
        String[] splitUsersRaw = usersRaw.split(",");
        List<User> users = new ArrayList<>();
        for (String personRaw : splitUsersRaw) {
            users.add(new User(personRaw.trim()));
        }
        return new Users(users);
    }
}
