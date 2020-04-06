package ladder.user;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> users;

    public Users(String names) {
        this.users = Stream.of(names.split(NAME_DELIMITER))
                .filter(name -> lengthValidator(name.length()))
                .collect(Collectors.toList());
    }

    private boolean lengthValidator(int length) {
        if (length > MAX_NAME_LENGTH) {
            throw new RuntimeException("이름이 길어요");
        }
        return true;
    }

    public List<String> users() {
        return users;
    }
}
