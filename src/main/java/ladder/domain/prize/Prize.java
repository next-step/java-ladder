package ladder.domain.prize;

import util.StringUtils;

import static util.Preconditions.checkArgument;

public class Prize {
    public static final String PRIZE_NAME_MUST_NOT_BE_BLANK = "prize name must not be blank";
    public static final String PRIZE_NAME_LENGTH_MUST_BE_FIVE_OR_LESS = "prize name length must be 5 or less";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Prize(final String name) {
        this.name = name;
    }

    public static Prize of(final String prizeName) {
        checkArgument(StringUtils.isNotBlank(prizeName), PRIZE_NAME_MUST_NOT_BE_BLANK);
        checkArgument(prizeName.length() <= MAXIMUM_NAME_LENGTH, PRIZE_NAME_LENGTH_MUST_BE_FIVE_OR_LESS);
        return new Prize(prizeName);
    }

    public String getName() {
        return name;
    }
}
