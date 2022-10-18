package nextstep.ladder.domain;

public class Person {

    private final static int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Person(String name) {
        validateName(name);
        validateLength(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("참여하는 사람의 이름이 입력되지 않았습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 최대 5자만 입력 가능합니다.");
        }
    }

    public String name() {
        return name;
    }
}
