package ladder;

public class LadderReward {
    private static final String MISS = "꽝";

    private final String textOfResult;

    private LadderReward(String textOfResult) {
        this.textOfResult = textOfResult;
    }

    public static LadderReward of(String textOfResult) {
        if (textOfResult == null) {
            throw new IllegalArgumentException("the text of result cannot be null");
        }

        textOfResult = textOfResult.trim();

        if (isNotNumber(textOfResult) && isNotMiss(textOfResult)) {
            throw new IllegalArgumentException("the text of result only can be '꽝' or '${number}'");
        }

        return new LadderReward(textOfResult);
    }

    public String getText() {
        return textOfResult;
    }

    private static boolean isNotMiss(String textOfResult) {
        return !MISS.equals(textOfResult);
    }

    private static boolean isNotNumber(String textOfResult) {
        try {
            Integer.parseInt(textOfResult);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
