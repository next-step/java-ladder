package ladder.domain.prize;

import util.StringUtils;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static util.Preconditions.checkArgument;

public class PrizesGenerator {
    private static final String SEPARATOR = ",";
    public static final String PRIZES_EXPRESSION_MUST_NOT_BE_BLANK = "prizeS expression must not be blank";

    public static Prizes generate(final String prizesExpression) {
        checkArgument(StringUtils.isNotBlank(prizesExpression), PRIZES_EXPRESSION_MUST_NOT_BE_BLANK);
        return Arrays.stream(prizesExpression.split(SEPARATOR))
                .map(Prize::of)
                .collect(collectingAndThen(toList(), Prizes::of));
    }
}
