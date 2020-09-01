package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderValidation;

public class User {

    private String name;

    public User() {
    }

    public User(final String name) {
        this.name = name;
        LadderValidation.validateUserNameIsBlank(name);
        LadderValidation.validateUserNameLength(name);
    }

}
