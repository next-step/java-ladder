package nextstep.ladder.domain.user;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.error.exception.UserSizeEmptyException;

public class Users {

    private List<User> users;

    public Users(String... userNames) {
        this(toUsers(userNames));
    }

    public Users(List<User> users) {
        if (users.size() == 0) {
            throw new UserSizeEmptyException(users);
        }
        this.users = users;
    }

    private static List<User> toUsers(String... userNames) {
        List<User> users = new ArrayList<>();
        for (String userName : userNames) {
            users.add(new User(userName));
        }
        return users;
    }

    public int size() {
        return users.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.toString());
        }
        return sb.toString();
    }
}
