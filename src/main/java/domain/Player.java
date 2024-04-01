package domain;

public class Player {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        assertNoBlank(name);
        assertLessThenFiveLength(name);
        this.name = name;
    }

    private void assertNoBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름이 빈 값입니다.");
        }
    }

    private void assertLessThenFiveLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
