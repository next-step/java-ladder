package nextstep.laddergame.domain;

public class Gamer {
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private final int index;

    public Gamer(String name, int index) {
        checkValidName(name);
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    private static void checkValidName(String name) throws IllegalArgumentException {
        if (name == null || NAME_LENGTH_LIMIT < name.length()) {
            throw new IllegalArgumentException("Wrong Input : Name Length is less than " + NAME_LENGTH_LIMIT);
        }
    }
}
