package ladder;

import ladder.ladderexceptions.InvalidUsersNumberException;

import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    Users(List<String> users) {
        if (users.size() < 2) {
            throw new InvalidUsersNumberException();
        }

        this.users = users.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return users.size();
    }
}
