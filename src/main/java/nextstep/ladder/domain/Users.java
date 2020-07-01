package nextstep.ladder.domain;

import nextstep.ladder.StringParser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(String names) {
        this.users = createUsers(names);
    }

    private List<User> createUsers(String names) {
        return StringParser.splitNames(names).stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int getCount() {
        return users.size();
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public List<String> getNames(){
        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
