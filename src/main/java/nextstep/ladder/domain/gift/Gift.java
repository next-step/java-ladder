package nextstep.ladder.domain.gift;

import nextstep.ladder.exception.NullArgumentException;
import nextstep.ladder.exception.OutOfRangeArgumentException;
import nextstep.util.StringUtils;

public class Gift {
    private static final int MAXIMUM_LENGTH_OF_GIFT = 5;

    private final String gift;

    private Gift(String gift) {
        validate(gift);

        this.gift = gift;
    }

    private void validate(String gift) {
        if (StringUtils.isEmpty(gift)) {
            throw new NullArgumentException("Gift");
        }

        if (gift.length() > MAXIMUM_LENGTH_OF_GIFT) {
            throw OutOfRangeArgumentException.lessThanOrEqualTo(MAXIMUM_LENGTH_OF_GIFT, gift.length());
        }
    }

    public static Gift from(String gift) {
        return new Gift(gift);
    }

    public String getGift() {
        return gift;
    }
}
