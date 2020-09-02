package nextstep.domain;

public class Person {

    public static boolean validateName(String name) {
        return PersonValidator.validateAll(name);
    }

}
