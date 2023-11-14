package nextstep.ladder.domain;

public class Name {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateNameOverThenFive(name);
        this.name = name;
    }

    private void validateBlank(String name) {
        if (isBlank(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private static void validateNameOverThenFive(String name) {
        if (isOverThenFive(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverThenFive(String name) {
        return name.length() > MAX_LENGTH;
    }
}
