package nextstep.ladder.domain;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Name(String name) {
        lengthCheck(name);
        this.name = name;
    }

    private void lengthCheck(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }
}
