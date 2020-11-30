package ladder.domain.user;

import util.StringUtils;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static util.Preconditions.checkArgument;

public class UsersGenerator {
    private static final String SEPARATOR = ",";
    public static final String USERS_EXPRESSION_MUST_NOT_BE_BLANK = "users expression must not be blank";

    public static Users generate(final String usersExpression) {
        checkArgument(StringUtils.isNotBlank(usersExpression), USERS_EXPRESSION_MUST_NOT_BE_BLANK);
        return Arrays.stream(usersExpression.split(SEPARATOR))
                .map(User::of)
                .collect(collectingAndThen(toList(), Users::of));
    }
}
