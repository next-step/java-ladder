package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ladder.utils.StringSplitter.splitStrings;

public class Users {
    private final List<User> users;

    public Users(List<String> users) {
        this.users = users.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public Users(String users) {
        this(splitStrings(users));
    }

    public String getUserName(int index) {
        return users.get(index).getName();
    }

    public List<String> getUserNames() {
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public int findUser(String userName) {
        return users.indexOf(new User(userName));
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
