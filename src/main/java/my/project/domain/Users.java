package my.project.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Users {
    public static final String DELIMITER = ",";
    public static final String OUT_OF_USERS = "참여자가 아닙니다.";
    public static final int FIRST_LINE = 0;
    public static final int USER_START_POINT = 2;

    private List<User> users;

    public Users(String sUsers) {
        //this.users = parseUsers(users);
        this.users = new ArrayList<>();
        String[] arrUsers = sUsers.split(DELIMITER);
        IntStream.range(0, arrUsers.length)
                .forEach(i -> users.add(new User(arrUsers[i], new Point(i * USER_START_POINT, FIRST_LINE))));
    }

    private List<User> parseUsers(String users) {
        return Arrays.stream(users.split(DELIMITER))
                .map(User::new)
                .collect(Collectors.toList());
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
}
