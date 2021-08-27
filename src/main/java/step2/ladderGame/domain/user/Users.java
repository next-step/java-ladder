package step2.ladderGame.domain.user;

import step2.ladderGame.domain.exception.CountOfUserOutOfBoundsException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Users {

    private static final String SEPARATOR = ",";
    private static final int MIN_COUNT_BY_USER = 2;

    private final List<User> users;

    public Users(String input) {
        String[] splitInput = input.split(SEPARATOR);

        validate(splitInput);

        users = Arrays.stream(splitInput)
                .map(User::new)
                .collect(Collectors.toList());
    }

    public void validate(String[] splitInput) {
        if (splitInput.length < MIN_COUNT_BY_USER) {
            throw new CountOfUserOutOfBoundsException();
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUserCount() {
        return users.size();
    }

}
