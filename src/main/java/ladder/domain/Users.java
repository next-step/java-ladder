package ladder.domain;

import ladder.dto.UsersDTO;
import ladder.ladderexceptions.InvalidUsersNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Users {

    private static final int MINIMUM_USER_COUNTS = 2;

    private final List<User> users;

    public Users(List<?> users) {
        validateUsers(users);
        this.users = castInputs(users);
    }

    private void validateUsers(List<?> users) {
        if (users.size() < MINIMUM_USER_COUNTS) {
            throw new InvalidUsersNumberException();
        }
    }

    private List<User> castInputs(List<?> users) {
        return users.stream()
                .map(this::castToUser)
                .collect(toList());
    }

    private User castToUser(Object o) {
        if (o instanceof String) {
            return new User((String) o);
        }

        return (User) o;
    }

    public Users passLayer(SwapRule rule) {
        List<User> swappedUsers = new ArrayList<>(users);

        for (int i = 0; i < swappedUsers.size() - 1; i++) {
            swapOnRule(swappedUsers, rule, i);
        }

        return new Users(swappedUsers);
    }

    private void swapOnRule(List<User> swappedUsers, SwapRule rule, int index) {
        if (rule.needToSwap(index)) {
            User temp = swappedUsers.get(index);
            swappedUsers.set(index, users.get(index + 1));
            swappedUsers.set(index + 1, temp);
        }
    }

    public int size() {
        return users.size();
    }

    public UsersDTO exportData() {
        return users.stream()
                .map(User::getName)
                .collect(collectingAndThen(toList(), UsersDTO::new));
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
