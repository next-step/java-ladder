package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private List<User> users;
    public Users(String userNames) {
        users = Arrays.stream(split(userNames))
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }

    private static String[] split(String inputNames) {
        return inputNames.split(",");
    }

    public int count() {
        return users.size();
    }
}
