package domain;

public class Player {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        assertLessThenFiveLength(name);
        this.name = name;
    }

    private void assertLessThenFiveLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
