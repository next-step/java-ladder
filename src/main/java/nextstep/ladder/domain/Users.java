package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String USER_NAME_SEPARATOR = ",";

    private List<User> users;

    public static Users toUsers(final String userNames) {
        return new Users(toUsers(split(userNames)));
    }

    private Users(List<User> users) {
        this.users = users;
    }

    private static String[] split(final String userNames) {
        return userNames.split(USER_NAME_SEPARATOR);
    }

    private static List<User> toUsers(final String[] userNames) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userNames.length; i++) {
            users.add(new User(userNames[i], i));
        }
        return users;
    }

    public int userCount() {
        return users.size();
    }

    public List<String> userNames() {
        return users.stream()
                .map(User::name)
                .collect(Collectors.toList());
    }

}
