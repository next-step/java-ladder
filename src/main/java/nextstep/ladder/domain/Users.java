package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Users {
    private static final String DUPLICATED_NAME_ERROR = "이름이 중복되었습니다.";
    private static final String SPLIT_DELIMITER = ",";

    private final List<User> users;

    public Users(String userNames) {
        validateDuplicatedNames(toUserList(userNames));
        this.users = toUserList(userNames);
    }

    private void validateDuplicatedNames(List<User> users) {
        HashSet<User> userSet = new HashSet<>(users);
        if (userSet.size() != users.size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_ERROR);
        }
    }

    private static List<User> toUserList(String userNames) {
        return Arrays.stream(split(userNames))
                .map(User::new)
                .collect(Collectors.toList());
    }

    private static String[] split(String userNames) {
        return userNames.split(SPLIT_DELIMITER);
    }


    public List<String> getUserNames() {
        return users.stream()
                .map(User::toString)
                .collect(Collectors.toList());
    }

    public int size() {
        return users.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "Users{" +
                "users=" + users +
                '}';
    }
}
