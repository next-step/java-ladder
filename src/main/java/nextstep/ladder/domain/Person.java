package nextstep.ladder.domain;

public class Person {
    private static final int NAME_LENGTH_MAX = 5;

    private final String name;

    public Person(String name) {
        if (name.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("글자수는 최대 5글자까지 부여할 수 있습니다.");
        }
        this.name = name;
    }

    public String name() {
        return this.name;
    }
}
