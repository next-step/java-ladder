package ladder.step4.domain;

import ladder.step4.exception.*;

import java.util.HashMap;
import java.util.Map;

public class LadderHeight {

    private static final Map<Integer, LadderHeight> FACTORY = new HashMap<>();
    private static final int MIN_HEIGHT = 1;

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
        return FACTORY.computeIfAbsent(height, LadderHeight::new);
    }

    public static void validateThatItsNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            throw new LadderHeightNonNumberException();
        }
    }

    public static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new LadderHeightMinimumSizeException();
        }
    }
}
