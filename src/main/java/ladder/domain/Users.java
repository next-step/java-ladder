package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static ladder.util.StringUtil.isBlank;

public class Users {

    private static final String USER_NAMES_EMPTY = "참여자 이름을 입력해야 합니다.";
    private static final String USER_NAMES_SEPARATOR = ",";

    private final List<User> users;

    private Users(List<User> users) {
        this.users = users;
    }

    public static Users of(String userNames) {
        return new Users(getSplitUserNames(userNames));
    }

    private static List<User> getSplitUserNames(String userNames) {
        if (isBlank(userNames))
            throw new IllegalArgumentException(USER_NAMES_EMPTY);

        return Arrays.stream(userNames.split(USER_NAMES_SEPARATOR))
                .map(User::of)
                .collect(Collectors.toList());
    }

    public int countOfPerson() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
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
}
