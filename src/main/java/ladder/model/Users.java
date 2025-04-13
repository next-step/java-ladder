package ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> names;

    public Users(String names) {
        this(Arrays.stream(names.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(User::new)
                .collect(Collectors.toList()));
    }

    public Users(List<User> names) {
        this.names = names;
    }

    public int size() {
        return names.size();
    }

    public List<String> getNames() {
        return names.stream().map(User::getName).collect(Collectors.toList());
    }

}
