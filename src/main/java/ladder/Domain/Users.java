package ladder.Domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Users {

    private final List<User> users;

    private Users(String uesrNames) {
        this.users = readyToUsers(uesrNames);
    }

    public static Users of(String uesrNames) {
        return new Users(uesrNames);
    }

    private List<User> readyToUsers(String userNames) {
        List<User> player = new ArrayList<>();
        String[] userNamesArr= userNames.split(",");

        for (int position = 0; position < userNamesArr.length; position++) {
            player.add(User.of(userNamesArr[position], Position.of(position)));
        }

        return player;
    }

    public List<User> toList() {
        return Collections.unmodifiableList(users);
    }
}
