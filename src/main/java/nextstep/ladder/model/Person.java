package nextstep.ladder.model;

public class Person {

    private static final String OUT_OF_LENGTH_MESSAGE = "이름의 길이를 초과했습니다. 이름은 최대 5자까지 허용합니다.";

    private final String name;

    private Person(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (name.isBlank() || name.length() < 1 || name.length() > 5) {
            throw new IndexOutOfBoundsException(OUT_OF_LENGTH_MESSAGE);
        }
    }

    public static Person is(String name) {
        return new Person(name);
    }

    public String name() {
        return this.name;
    }
}
