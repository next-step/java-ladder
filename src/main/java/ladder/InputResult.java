package ladder;

import java.util.Arrays;
import java.util.Objects;

public class InputResult {

    private final String[] ladderResults;

    public InputResult(String strings, int playerSize) {
        this(strings.split(DELIMITER), playerSize);
    }

    public InputResult(String[] strings, int playerSize) {
        this.ladderResults = strings;
        validSize(playerSize);
    }

    private void validSize(int playerSize) {
        if (playerSize != ladderResults.length) {
            throw new IllegalArgumentException("invalid result or player size");
        }
    }

    public String[] getLadderResults() {
        return ladderResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof InputResult))
            return false;
        InputResult that = (InputResult)o;
        return Objects.deepEquals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ladderResults);
    }

    public String get(int index) {
        return ladderResults[index];
    }
}
