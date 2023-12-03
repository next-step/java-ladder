package nextstep.ladder.model;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        checkNameValidity(name);
        this.name = name;
    }

    private void checkNameValidity(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }

    public String name(){
        return this.name;
    }
}
