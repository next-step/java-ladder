package ladder.domain.user;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private static final String NAME_DELIMITER = ",";

    private final List<User> users;

    public Users(String names) {
        this.users = Stream.of(names.split(NAME_DELIMITER))
                .map(name -> name.trim())
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }

    public int countOfUser() {
        return users.size();
    }

    public List<User> showUsers() {
        return users.stream()
                .map(user -> user.user())
                .collect(Collectors.toList());
    }

    public int findUserPosition(String name) {
        return hasNameValidator(name);
    }

    private int hasNameValidator(String name) {
        int position = users.indexOf(new User(name));
        if(position == -1) {
            throw new IllegalArgumentException("입력한 이름은 존재하지 않습니다.");
        }
        return position;
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
