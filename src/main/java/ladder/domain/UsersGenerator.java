package ladder.domain;

import util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class UsersGenerator {
    private static final String SEPARATOR = ",";
    public static final String USERS_EXPRESSION_MUST_NOT_BE_BLANK = "users expression must not be blank";

    public static Users generate(final String usersExpression) {
        checkArgument(StringUtils.isNotBlank(usersExpression), USERS_EXPRESSION_MUST_NOT_BE_BLANK);
        final List<User> userList = Arrays.stream(usersExpression.split(SEPARATOR))
                .map(User::of)
                .collect(Collectors.toList());
        return Users.of(userList);
    }
}
