package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users;

    public Users(List<String> names) {
        this.users = names.stream().map(User::new).collect(Collectors.toList());
    }

    public String getUserName(int idx) {
        return users.get(idx).getName();
    }

    public int indexOfUser(String name) {
        return users.stream()
                    .filter(u -> u.isEqualName(name))
                    .map(users::indexOf)
                    .findAny()
                    .orElseThrow(IllegalArgumentException::new);
    }

    public int getCountOfUser() {
        return users.size();
    }
}
