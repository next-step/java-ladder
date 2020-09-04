package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderValidation;
import nextstep.ladder.utils.StringUtils;

public class User {

    private String name;

    public User(final String name) {
        this.name = name;
        LadderValidation.validateUserNameIsBlank(name);
        LadderValidation.validateUserNameLength(name);
    }

    public static String[] splitByUserName(String names) {
        return StringUtils.splitBy(names);
    }

    public String getName() {
        return name;
    }

}
