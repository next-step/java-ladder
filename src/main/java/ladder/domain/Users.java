package ladder.domain;


import ladder.LadderUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<String> userNamesArr = LadderUtil.splitStringByComma(userNames);

        for (int position = 0; position < userNamesArr.size(); position++) {
            player.add(User.of(userNamesArr.get(position), Position.of(position)));
        }

        return player;
    }

    private void minimumUserException(String userNames) {
        if (userNames.trim().isEmpty()) {
            throw new MinimumUserException(userNames + "is empty");
        }
    }

    public User findUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow();
    }
    public int size() {
        return users.size();
    }

    public List<User> toList() {
        return Collections.unmodifiableList(users);
    }

}
