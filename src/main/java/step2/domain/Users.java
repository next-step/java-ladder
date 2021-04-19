package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static step2.view.ViewConstants.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users = new ArrayList<>();

    public Users(String names) {
        createUsers(names);
    }

    public int size() {
        return users.size();
    }

    private void createUsers(String names) {
        Arrays.stream(names.split(COMMA))
            .map(User::new)
            .collect(collectingAndThen(toList(), users::addAll));
    }

    @Override
    public String toString() {
        return users.stream()
            .map(User::toString)
            .collect(Collectors.joining());
    }
}
