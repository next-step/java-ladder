package ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class User {
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    private User(String name) {
        validateNullOrEmpty(name);
        validateNameLength(name);
        this.name = name;
    }

    public static User of(String name) {
        return new User(name);
    }

    public static List<User> of(List<String> names) {
        return names.stream().map(User::new).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(String name) {
        if(name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("입력된 이름이 제한 길이를 초과 합니다.");
        }
    }

    private void validateNullOrEmpty(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("입력된 이름이 null 또는 빈 값 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
