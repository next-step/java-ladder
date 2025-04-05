package nextstep.ladder.domain;

public class Person {

    private final String name;

    public Person(String name) {
        checkNameLength(name);
        checkNameNotNull(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }

    private void checkNameNotNull(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    public String name() {
        return name;
    }
}
