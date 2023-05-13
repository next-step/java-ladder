package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Users {
    private static final String NAME_DELIMITER = ",";
    private final List<User> users;

    public Users(List<String> users) {
        this.users = users.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public Users(String users) {
        this(Users.splitNames(users));
    }

    public static List<String> splitNames(String names) {
        return Arrays.asList(names.split(NAME_DELIMITER));
    }

    public String getUserName(int index) {
        return users.get(index).getName();
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

    public int numberOfUsers() {
        return users.size();
    }
}
