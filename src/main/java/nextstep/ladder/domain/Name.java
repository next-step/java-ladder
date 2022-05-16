package nextstep.ladder.domain;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH || name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
