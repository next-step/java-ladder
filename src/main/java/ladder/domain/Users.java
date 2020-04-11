package ladder.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Users {

    private final List<User> users;

    private Users(String uesrNames) {
        minimumUserException(uesrNames);
        this.users = readyToUsers(uesrNames);
    }

    public static Users of(String uesrNames) {
        return new Users(uesrNames);
    }

    private List<User> readyToUsers(String userNames) {
        List<User> player = new ArrayList<>();
        String[] userNamesArr = userNames.split(",");

        for (int position = 0; position < userNamesArr.length; position++) {
            player.add(User.of(userNamesArr[position], Position.of(position)));
        }

        return player;
    }

    private void minimumUserException(String userNames) {
        if (userNames.trim().isEmpty()) {
            throw new MinimumUserException(userNames + "is empty");
        }
    }

    public int size() {
        return users.size();
    }

    public List<User> toList() {
        return Collections.unmodifiableList(users);
    }
}
