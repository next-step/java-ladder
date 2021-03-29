package ladder.domain;

public class Person {
    private static final String NAME_MAX_LENGTH_ERROR = "사람 이름은 최대 5글자 입니다.";
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validNameLengthFiveOver(name);
        this.name = name;
    }

    private static void validNameLengthFiveOver(String name) {
        if (name.isEmpty()
                || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_MAX_LENGTH_ERROR);
        }
    }

    public boolean isName(String name) {
        return this.name.equals(name);
    }

    public String name() {
        return name;
    }
}
