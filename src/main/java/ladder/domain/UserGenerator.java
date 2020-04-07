package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserGenerator {
    private static final String DELIMETER = ",";

    private final String names;

    public UserGenerator(final String names) {
        this.names = names;
    }

    public List<User> generateUsers() {
        return Stream.of(names.split(DELIMETER))
                .map(String::trim)
                .map(User::new)
                .collect(Collectors.toList());
    }


}
