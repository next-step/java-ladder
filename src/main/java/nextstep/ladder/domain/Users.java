package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class Users {

    private static final String COMMA = ",";
    private static final int EMPTY = 0;

    private final List<User> users;

    public Users(String usersNameString) {
        throwIfNullOrEmpty(usersNameString);
        AtomicInteger index = new AtomicInteger();
        this.users = Arrays.stream(usersNameString.split(COMMA))
                .map(name -> new User(name, index.getAndIncrement()))
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        throwIfInvalidUserSize(users);
    }

    private void throwIfNullOrEmpty(String usersNameString) {
        if (usersNameString == null || usersNameString.length() == EMPTY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USERS_NAME_STRING);
        }
    }

    private void throwIfInvalidUserSize(List<User> users) {
        if (users.size() < 2) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USERS_SIZE);
        }
    }

    public int size() {
        return this.users.size();
    }

    public List<User> export() {
        return this.users;
    }

    public User getUser(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_USER_NAME));
    }

}
