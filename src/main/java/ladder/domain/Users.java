package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Users {
    public static final String COMMA_SEPARATOR = ",";
    private final List<User> users;

    public Users(final String users) {
        validateUserMinCount(users);
        this.users = splitToUser(users);
    }

    private void validateUserMinCount(String users) {
        if(!users.contains(COMMA_SEPARATOR)){
            throw new IllegalArgumentException("사용자는 2명 이상이어야 합니다.");
        }
    }

    private static List<User> splitToUser(String value) {
        AtomicInteger index = new AtomicInteger();
        return Arrays.stream(value.split(COMMA_SEPARATOR))
                .map(name -> new User(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUserCount() {
        return users.size();
    }
}
