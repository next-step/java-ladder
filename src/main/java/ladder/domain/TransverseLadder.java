package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class TransverseLadder {

    private final List<Boolean> lines;
    private final LadderGenerateStrategy ladderGenerateStrategy;

    public TransverseLadder(LadderGenerateStrategy ladderGenerateStrategy, Participants participants) {
        this.ladderGenerateStrategy = ladderGenerateStrategy;

        this.lines = new ArrayList<>();
        for (int index = 0; index < participants.size() - 1; index++) {
            lines.add(getLadder(index));
        }
    }

    protected Boolean getLadder(int index) {
        if (isFirstIndex(index)) {
            return ladderGenerateStrategy.isGenerating();
        }

        if (Boolean.FALSE.equals(existsLadder(index - 1))) {
            return ladderGenerateStrategy.isGenerating();
        }

        return false;
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    public Boolean existsLadder(int index) {
        return lines.get(index);
    }

    public int size() {
        return lines.size();
    }

}
