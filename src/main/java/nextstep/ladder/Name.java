package nextstep.ladder;

public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        checkNameLengthIsValid(name);
    }

    private void checkNameLengthIsValid(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("이름 길이는 %d ~ %d 사이어야 합니다.", MIN_LENGTH, MAX_LENGTH)
            );
        }
    }
}
