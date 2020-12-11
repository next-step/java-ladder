package my.project.step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    public static final String DELIMITER = ",";
    public static final String OUT_OF_USERS = "참여자가 아닙니다.";

    private final List<User> users;

    public Users(String sUsers) {
        this.users = new ArrayList<>();

        List<String> userList = Arrays.stream(sUsers.split(DELIMITER))
                .collect(Collectors.toList());

        for (int i = 0; i < userList.size(); i++) {
            users.add(new User(userList.get(i), i));
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String name) {
        return users.stream()
                .filter(user -> user.matchName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(OUT_OF_USERS));
    }

    public Point getUserPoint(String name) {
        return getUser(name).getPoint();
    }

    public int size() {
        return users.size();
    }
}
