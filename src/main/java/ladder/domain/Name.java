package ladder.domain;

public class Name {
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 6;

    private final String name;

    public Name(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값을 입력 할 수 없습니다.");
        }

        if (name.length() < MINIMUM_NAME_LENGTH  || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 글자만 허용됩니다.");
        }

        this.name = name;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
