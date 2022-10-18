package nextstep.ladder;

public class Person {

    private final static int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 최대 5자만 입력 가능합니다.");
        }
    }

    public String name() {
        return name;
    }
}
