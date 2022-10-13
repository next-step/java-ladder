package nextstep.laddergame.wrapper;

import java.util.regex.Pattern;

public class Height {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]\\d*(\\.\\d+)?$");
    private static final String EXCEPTION_MESSAGE = "Wrong Input : Ladder Height is not a number";

    private final int ladderHeight;

    public Height(String ladderHeightString) {
        if (!isNumber(ladderHeightString)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        this.ladderHeight = Integer.parseInt(ladderHeightString);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    private static boolean isNumber(String numberString) {
        return NUMBER_PATTERN.matcher(numberString).find();
    }

}