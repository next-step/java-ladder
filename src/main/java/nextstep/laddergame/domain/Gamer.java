package nextstep.laddergame.domain;

public class Gamer {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Gamer(String name) {
        checkValidName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static void checkValidName(String name) throws IllegalArgumentException {
        if (name == null || NAME_LENGTH_LIMIT < name.length()) {
            throw new IllegalArgumentException("Wrong Input : Name Length is less than " + NAME_LENGTH_LIMIT);
        }
    }
}
