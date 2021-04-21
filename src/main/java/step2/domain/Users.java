package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static step2.view.ViewConstants.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Users {

    private final List<User> users = new ArrayList<>();

    public Users(String names) {
        createUsers(names);
    }

    public int size() {
        return users.size();
    }

    public List<User> value() {
        return this.users;
    }

    private void createUsers(String names) {
        Arrays.stream(names.split(COMMA))
            .map(User::new)
            .collect(collectingAndThen(toList(), users::addAll));
    }
}
