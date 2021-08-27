package nextstep.laddergame.domain;

public class PlayerName {

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT = "유효하지 않은 이름입니다. name: %s";

    private final String name;

    private PlayerName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NAME_LENGTH_EXCEPTION_MESSAGE_FORMAT, name));
        }
    }

    public static PlayerName of(String name) {
        return new PlayerName(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
