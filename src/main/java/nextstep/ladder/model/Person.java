package nextstep.ladder.model;

public class Person {
    private static final String EMPTY_NAME_EXCEPTION_MESSAGE = "공백뿐인 이름은 사용할 수 없습니다.";
    private static final String EXCEEDED_NAME_LENGTH_EXCEPTION_MESSAGE = "이름의 길이는 5자를 초과할 수 없습니다.";

    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_EXCEPTION_MESSAGE);
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException(EXCEEDED_NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
