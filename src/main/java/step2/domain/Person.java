package step2.domain;

public class Person {
    private static final String NAME_LIMIT_EXCEPTION = "이름은 최대 5글자까지만 입력 가능합니다.";
    public static final int NAME_LIMIT = 5;

    private final String name;

    private Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
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
