package nextstep.ladder.domain;

public class UserName {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String NAME_OUT_OF_RANGE_MESSAGE = "이름은 5글자를 넘을 수 없습니다.";

    private final String name;

    public UserName(final String name) {
        validate(name);
        this.name = name;
    }

    public void validate(final String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_OUT_OF_RANGE_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
