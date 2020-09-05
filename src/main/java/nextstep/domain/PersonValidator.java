package nextstep.domain;

import java.util.Arrays;

public enum PersonValidator {

    NULL_OR_EMPTY(name -> StringUtils.isNullOrEmpty(name)),
    MAX_LENGTH(name -> name.length() > Constants.MAX_LENGTH)
    ;

    private PersonValidate personValidate;

    PersonValidator(PersonValidate personValidate) {
        this.personValidate = personValidate;
    }

    public boolean validate(String name) {
        return personValidate.validate(name);
    }

    public static boolean validateName(String name) {
        return Arrays.stream(values())
                .noneMatch(personValidator -> personValidator.validate(name));
    }

    private static class Constants {

        private static final int MAX_LENGTH = 5;

    }

}
