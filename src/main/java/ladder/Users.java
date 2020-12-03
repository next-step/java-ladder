package ladder;

import ladder.DTO.UsersDTO;
import ladder.ladderexceptions.InvalidUsersNumberException;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Users {

    private final List<User> users;

    Users(List<String> users) {
        if (users.size() < 2) {
            throw new InvalidUsersNumberException();
        }

        this.users = users.stream()
                .map(User::new)
                .collect(toList());
    }

    public int size() {
        return users.size();
    }

    public UsersDTO exportData() {
        return users.stream()
                .map(User::getName)
                .collect(collectingAndThen(toList(), UsersDTO::new));
    }
}
