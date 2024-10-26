package nextstep.ladder.domain;

public class Person {
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Person(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력 가능합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
