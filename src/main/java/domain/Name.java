package domain;

public class Name {

    public static final int MAX_LENGTH = 5;

    private final String value;

    public Name(String name) {
        assertLessThenFiveLength(name);
        this.value = name;
    }

    private void assertLessThenFiveLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
