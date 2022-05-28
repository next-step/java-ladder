package ladder.domain.player;

import ladder.exception.TooLongNameException;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    private String name;

    public Name(String name) {
        validate(name);

        this.name = name;
    }

    private static void validate(String name)  {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new TooLongNameException("이름의 길이는 최대 5입니다");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
