package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = Collections.unmodifiableList(new ArrayList<>(users));
    }

    public Users(String[] splitUserNames) {
        this.users = Arrays
                .stream(splitUserNames)
                .map(User::new)
                .collect(Collectors.toList());
    }

    public int getCountOfPerson() {
        return users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
