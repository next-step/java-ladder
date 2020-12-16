package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class Users {

    private static final String COMMA = ",";
    private static final int EMPTY = 0;

    private final List<User> users;

    public Users(String usersNameString) {
        throwIfNullOrEmpty(usersNameString);
        this.users = Arrays.stream(usersNameString.split(COMMA))
                .map(User::new)
                .collect(collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        throwIfInvalidUserSize(users);
    }

    private void throwIfNullOrEmpty(String usersNameString) {
        if (usersNameString == null || usersNameString.length() == EMPTY) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USERS_NAME_STRING);
        }
    }

    private void throwIfInvalidUserSize(List<User> users){
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

    public int indexOf(User user){
        return users.indexOf(user);
    }

}
