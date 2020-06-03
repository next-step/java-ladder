package ladder.step3.domain;

import ladder.step3.exception.*;

import java.util.HashMap;
import java.util.Map;

public class LadderHeight {

    private static final Map<Integer, LadderHeight> FACTORY = new HashMap<>();

    private final int value;

    private LadderHeight(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LadderHeight valueOf(String height) {
        validateThatItsNumber(height.trim());
        return valueOf(Integer.parseInt(height.trim()));
    }

    public static LadderHeight valueOf(int height) {
        validateHeight(height);
        LadderHeight ladderHeight = FACTORY.get(height);
        if (ladderHeight == null) {
            ladderHeight = new LadderHeight(height);
            FACTORY.put(height, ladderHeight);
        }
        return ladderHeight;
    }

    public static void validateThatItsNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            throw new LadderHeightNonNumberException();
        }
    }

    public static void validateHeight(int height) {
        if (height < 1) {
            throw new LadderHeightMinimumSizeException();
        }
    }
}
