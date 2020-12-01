package nextstep.ladder.domain;

import nextstep.ladder.ErrorMessage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String COMMA = ",";

    private final List<User> users;

    public Users(String usersNameString) {
        throwIfNullOrEmpty(usersNameString);
        this.users = Collections.unmodifiableList(
                Arrays
                        .stream(usersNameString.split(COMMA))
                        .map(User::new)
                        .collect(Collectors.toList())
        );
    }

    private void throwIfNullOrEmpty(String usersNameString) {
        if (usersNameString == null || usersNameString.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_USERS_NAME_STRING);
        }
    }

    public List<User> export() {
        return this.users;
    }

}
