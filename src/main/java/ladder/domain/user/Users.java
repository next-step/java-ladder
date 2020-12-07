package ladder.domain.user;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import ladder.exception.LadderGameException;

public class Users {

    private static final int MIN_USER_COUNT = 2;
    private static final String USER_SHOULD_EQUAL_OR_OVER_N = "참가자 수는 %d명 이상이어야 합니다.";
    private static final String PLEASE_INPUT_NOT_DUPLICATE_USER = "중복되지 않은 참가자를 입력해주세요.";
    private static final String NOT_INPUT_USER_NAME = "참가자 이름을 입력 해주세요!";

    private final List<User> users;

    public static Users from(List<User> users) {
        checkUserCount(users);
        checkUserName(users);
        return new Users(users);
    }

    private Users(List<User> users) {
        this.users = users;
    }

    public int getUsersCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

    private static void checkUserName(List<User> users) {
        int validNameCount = users.stream()
            .map(User::getName)
            .collect(Collectors.toSet()).size();

        if (validNameCount < users.size()) {
            throw new LadderGameException(PLEASE_INPUT_NOT_DUPLICATE_USER);
        }
    }

    public User getUserByName(String name) {
        return users.stream()
            .filter(u -> u.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new LadderGameException(NOT_INPUT_USER_NAME));
    }

    private static void checkUserCount(List<User> users) {
        if (users.size() < MIN_USER_COUNT) {
            throw new LadderGameException(String.format(USER_SHOULD_EQUAL_OR_OVER_N, MIN_USER_COUNT));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Users users1 = (Users) o;
        return Objects.equals(users, users1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }
}
