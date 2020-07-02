package nextstep.ladder.domain;

public class User {
    private final String name;
    private final int position;

    private static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "Null 혹은 공백을 입력할 수 없습니다.";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 최대 5자를 넘길 수 없습니다.";

    public User(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION_MESSAGE);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public int getPosition() {
        return position;
    }


    public String getName() {
        return name;
    }
}
