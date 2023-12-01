package ladder.domain;

public class Person {

    public static final int MAX_LENGTH = 5;
    private final String name;

    public Person(String name) {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 1 ~ 5 자입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String spaceAddedName() {
        return String.format("%6s", name);
    }
}
