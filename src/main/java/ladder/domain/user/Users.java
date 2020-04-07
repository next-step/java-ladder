package ladder.domain.user;

import ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Users implements Line {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private final List<String> users;

    public Users(String names) {
        this.users = Stream.of(names.split(NAME_DELIMITER))
                .map(name -> name.trim())
                .filter(name -> lengthValidator(name.length()))
                .collect(Collectors.toList());
    }

    private boolean lengthValidator(int length) {
        if (length > MAX_NAME_LENGTH) {
            throw new RuntimeException("이름이 길어요");
        }
        return true;
    }
    public int countOfUser(){
        return users.size();
    }

    @Override
    public List<String> getLine() {
        return users;
    }
}
