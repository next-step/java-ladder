package ladder;

import java.util.Arrays;
import java.util.Objects;

public class LadderResult {

    private final String[] ladderResults;

    public LadderResult(String[] strings) {
        this.ladderResults = strings;
    }

    public void validSize(int playerSize) {
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
        if (!(o instanceof LadderResult))
            return false;
        LadderResult that = (LadderResult)o;
        return Objects.deepEquals(ladderResults, that.ladderResults);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ladderResults);
    }
}
