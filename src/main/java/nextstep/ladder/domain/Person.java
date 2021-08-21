package nextstep.ladder.domain;

public class Person {

    public static final int MAX_NAME = 5;
    private final String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person of(String name) {
        if (name.length() > MAX_NAME) {
            throw new IllegalArgumentException("5자리이 이하로 입력해주세요");
        }
        return new Person(name);
    }

    public String getName() {
        return name;
    }
}
