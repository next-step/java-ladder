package nextstep.ladder;

public class Name {

    private final String name;

    public Name(String name) {
        validateNameOverThenFive(name);
        this.name = name;
    }

    private static void validateNameOverThenFive(String name) {
        if (isOverThenFive(name)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOverThenFive(String name) {
        return name.length() > 5;
    }
}
