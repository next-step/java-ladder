package ladder.domain;

import ladder.exception.InvalidInputException;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
    private static final int MIN_SIZE = 2;
    private static final String INVALID_COUNT_OF_USER_MESSAGE = MIN_SIZE + "명 이상의 참여자를 입력하세요.";

    private List<Name> names;

    private Users(List<String> users) {
        if (users.size() < MIN_SIZE) {
            throw new InvalidInputException(INVALID_COUNT_OF_USER_MESSAGE);
        }
        names = users.stream()
                     .map(Name::valueOf)
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

    public Name get(int index) {
        return names.get(index);
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
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
