package nextstep.ladder.step4.domain.player;

import nextstep.ladder.step4.exception.ArgumentNullPointerException;

public class StringAsSplit {

    private static final String DELIMITER = ",";

    private final String string;

    public StringAsSplit(String string) {
        valid(string);
        this.string = string;
    }

    public String[] split() {
        return string.split(DELIMITER);
    }

    private void valid(String string) {
        if (string == null || string.isEmpty()) {
            throw new ArgumentNullPointerException();
        }
    }

}
