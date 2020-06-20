package ladder.domain;

import java.util.Objects;

public class Person {
    public static final String NAME_LIMIT_EXCEPTION = "이름은 최대 5글자까지만 입력 가능합니다.";

    private static final int NAME_LIMIT = 5;
    private static final String NAME_NULL_EXCEPTION = "이름은 빈값이 올 수 없습니다.";

    private final String name;

    private Person(String name) {
        validateNameNull(name);
        validateNameLimit(name);
        this.name = name;
    }

    private void validateNameNull(String name) {
        if (Objects.isNull(name) || name.isEmpty()){
            throw new IllegalArgumentException(NAME_NULL_EXCEPTION);
        }
    }

    private void validateNameLimit(String name) {
        if (name.length() > NAME_LIMIT){
            throw new IllegalArgumentException(NAME_LIMIT_EXCEPTION);
        }
    }

    public static Person of(String name){
        return new Person(name);
    }

    public String getName() {
        return name;
    }
}
