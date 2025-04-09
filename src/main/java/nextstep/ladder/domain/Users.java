package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private List<User> users;

    public Users(String names) {
        this.users = Stream.of(names.split(",")).map(User::new).collect(Collectors.toList());
    }
}
