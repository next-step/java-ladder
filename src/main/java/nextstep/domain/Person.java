package nextstep.domain;

public class Person {

    private final String name;

    public Person(String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean validateName(String name) {
        return PersonValidator.validateAll(name);
    }

}
