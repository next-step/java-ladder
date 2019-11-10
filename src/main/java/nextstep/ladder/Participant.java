package nextstep.ladder;

public class Participant {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String MAX_NAME_LENGTH_ERROR_MSG = "이름은 5글자를 넘길 수 없습니다. [이름] : %s";

    private final String name;

    public Participant(String name) {
        assertName(name);
        this.name = name;
    }

    private void assertName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format(MAX_NAME_LENGTH_ERROR_MSG, name));
        }
    }

    public String getName() {
        return name;
    }
}
