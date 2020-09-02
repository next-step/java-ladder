package nextstep.ladder.domain;

import nextstep.ladder.utils.LadderValidation;
import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private String name;

    private User(final String name) {
        this.name = name;
        LadderValidation.validateUserNameIsBlank(name);
        LadderValidation.validateUserNameLength(name);
    }

    public static List<User> generateUsers(String names) {
        return Arrays.stream(getUserName(names))
                .map(User::new)
                .collect(Collectors.toList());
    }

    public static String[] getUserName(String names) {
        return StringUtils.splitBy(names);
    }

    public String getName() {
        return name;
    }

}
