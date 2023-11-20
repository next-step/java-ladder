package nextstep.ladder.domain;

import nextstep.ladder.exception.BlankNameException;
import nextstep.ladder.exception.NameOverLengthException;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private final String user;

    public Name(String name) {
        validateNameLength(name);
        this.user = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty()) {
            throw new BlankNameException();
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new NameOverLengthException();
        }
    }

    public String user() {
        return user;
    }
}
