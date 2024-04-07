package nextstep.ladder.domain.user;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.error.exception.UserSizeEmptyException;

public class Users {

    private final List<User> users;

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

    public User findUser(int userIndex){
        return users.get(userIndex);
    }

    public int size() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
