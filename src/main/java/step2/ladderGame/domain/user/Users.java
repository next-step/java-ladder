package step2.ladderGame.domain.user;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Users {

    private static final String SEPARATOR = ",";

    private final List<User> users;

    public Users(String input) {
        String[] splitInput = input.split(SEPARATOR);
        AtomicInteger index = new AtomicInteger();

        users = Arrays.stream(splitInput)
                .map(User::new)
                .collect(Collectors.toList());
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUserCount() {
        return users.size();
    }

}
