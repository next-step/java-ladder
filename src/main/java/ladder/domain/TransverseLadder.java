package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class TransverseLadder {

    private final List<Boolean> lines;

    public TransverseLadder(int personCount) {
        valid(personCount);
        lines = new ArrayList<>(personCount - 1);
        for (int i = 0; i < personCount-1; i++) {
            lines.add(getPoint(i, new RandomLadderGenerateStrategy()));
        }
    }

    protected Boolean getPoint(int i, LadderGenerateStrategy ladderGenerateStrategy) {
        if (i == 0) {
            return ladderGenerateStrategy.isGenerating();
        }

        boolean beforeLine = this.lines.get(i - 1);
        if (Boolean.FALSE.equals(beforeLine)) {
            return ladderGenerateStrategy.isGenerating();
        }

        return false;
    }

    public List<Boolean> getPoints() {
        return lines;
    }

    public int size() {
        return lines.size();
    }

    private void valid(int personCount) {
    }
}
