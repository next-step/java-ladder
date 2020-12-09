package my.project.dto;

import my.project.domain.Point;
import my.project.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Users {
    public static final String DELIMITER = ",";
    public static final String OUT_OF_USERS = "참여자가 아닙니다.";
    public static final int FIRST_LINE = 0;
    public static final int USER_START_POINT = 2;

    private final List<User> users;

    public Users(String sUsers) {
        this.users = new ArrayList<>();
        String[] arrUsers = sUsers.split(DELIMITER);
        IntStream.range(0, arrUsers.length)
                .forEach(i -> users.add(new User(arrUsers[i], new Point(i * USER_START_POINT, FIRST_LINE))));
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
