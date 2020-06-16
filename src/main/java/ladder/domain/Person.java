package ladder.domain;

public class Person {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;

    private Person(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public static Person from(String name) {
        return new Person(name);
    }

    public String getName() {
        return name;
    }

    private void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자 까지 가능 합니다.");
        }
    }
}
