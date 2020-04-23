package ladder.domain;

import java.util.ArrayList;
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
        String[] splitText = names.split(DELIMETER);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < splitText.length; i++) {
            users.add(new User(splitText[i], i));
        }
        return new ArrayList<>(users);
    }


}
