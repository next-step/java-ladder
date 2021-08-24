package ladder.domain;

import ladder.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {
    private static final int USERS_MINIMUM_COUNT = 2;
    private static final String INVALID_COUNT_OF_USER_MESSAGE = USERS_MINIMUM_COUNT + "명 이상의 참여자를 입력하세요.";

    private List<Name> names;

    private Users(List<String> users) {
        if (users.size() < USERS_MINIMUM_COUNT) {
            throw new InvalidInputException(INVALID_COUNT_OF_USER_MESSAGE);
        }

        names = users.stream()
                     .map(Name::new)
                     .collect(Collectors.toList());
    }

    public static Users valueOf(List<String> users) {
        return new Users(users);
    }

    public static Users valueOf(String[] users) {
        return valueOf(Arrays.asList(users));
    }

    public static Users valueOf(String users) {
        return valueOf(users.replace(" ", "").split(","));
    }

    public List<Name> getNames() {
        return new ArrayList<>(names);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(names, users1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

}
