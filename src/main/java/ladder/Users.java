package ladder;

import ladder.ladderexceptions.InvalidUsersNumberException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    Users(List<String> users) {
        this.users = Optional.of(users)
                .filter(list -> list.size() >= 1)
                .orElseThrow(InvalidUsersNumberException::new)

                .stream()
                .map(User::new)
                .collect(Collectors.toList());
    }
}
