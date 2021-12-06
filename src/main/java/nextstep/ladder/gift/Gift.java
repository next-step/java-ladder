package nextstep.ladder.gift;

import nextstep.ladder.domain.exception.InvalidNameLengthException;

public class Gift {

    private static final int MIN_NAME_LENGTH = 1;

    private final String gift;

    public Gift(String gift) {
        checkNameLength(gift);
        this.gift = gift;
    }

    private void checkNameLength(String gift) {
        if (gift == null || gift.length() < MIN_NAME_LENGTH) {
            throw new InvalidNameLengthException(MIN_NAME_LENGTH);
        }
    }
}
