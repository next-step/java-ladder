package ladder.model;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    public static final String NAME_MIN_LENGTH_MSG = "이름은 최소 1글자입니다.";
    public static final String NAME_MAX_LENGTH_MSG = "이름은 최대 5글자입니다.";

    private String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(NAME_MIN_LENGTH_MSG);
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_MSG);
        }
    }

    public String getName() {
        return name;
    }
}
