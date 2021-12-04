package ladder.domain;

public class Name {
    private static final int NAME_LENGTH_MAX = 5;
    private static final String NAME_LENGTH_ERROR_MESSAGE = "error : 이름은 최대 %d글자 입니다.";
    private static final String EMPTY_ERROR_MESSAGE = "error : 공백은 사용할수 없습니다.";

    private final String name;

    public Name(String name) {
        checkNameEmpty(name);
        validNameLength(name);
        this.name = name;
    }

    private static void checkNameEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private void validNameLength(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR_MESSAGE, NAME_LENGTH_MAX));
        }
    }

    public String value() {
        return name;
    }
}
