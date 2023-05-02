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
        List<String> splitNames = Arrays.asList(names.split(NAME_DELIMITER));
        if (hasNameLengthOverInList(splitNames)) {
            throw new IllegalArgumentException("이름이 " + NAME_DELIMITER + "로 구분되지 않았거나 글자 수를 초과하였습니다.");
        }
        return splitNames;
    }

    private static boolean hasNameLengthOverInList(List<String> names) {
        return names.stream()
                .anyMatch(User::isNameLengthOver);
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

    public int size() {
        return users.size();
    }
}
