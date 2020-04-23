package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class UserGenerator {
    private static final String DELIMETER = ",";

    private final String names;
    private List<User> users;

    public UserGenerator(final String names) {
        this.names = names;
        this.users = new ArrayList<>();
    }

    public List<User> generateUsers() {
        String[] splitText = names.split(DELIMETER);
        for (int i = 0; i < splitText.length; i++) {
            users.add(new User(splitText[i], i));
        }
        return new ArrayList<>(users);
    }


}
