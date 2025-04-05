package ladder.domain;

public class Person {
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Person(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이는 최대 " + NAME_MAX_LENGTH + "자입니다.");
        }
        this.name = name;
    }

    public String name() {
        return name;
    }
}
