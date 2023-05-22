package nextstep.ladder.domain.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private static final String SPLIT_REGEX = ",";
    private final List<User> users = new ArrayList<>();

    public Users(String input) {
        String[] names = input.split(SPLIT_REGEX);
        Arrays.stream(names).forEach((name) -> users.add(new User(name)));
    }

    public void add(User user) {
        this.users.add(user);
    }

    public int userCount() {
        return this.users.size();
    }

    @Override
    public String toString() {
        return users.stream().map(User::toString).collect(Collectors.joining(""));
    }
}