package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class TransverseLadder {

    private final List<Boolean> lines;

    public TransverseLadder(int participantsCount) {
        this.lines = new ArrayList<>();
        for (int index = 0; index < participantsCount - 1; index++) {
            lines.add(getLadder(index));
        }
    }

    private Boolean getLadder(int index) {

        if (isFirstIndex(index) || Boolean.FALSE.equals(existsLadder(index - 1))) {
            return getLine(new RandomLadderGenerateStrategy());
        }
        return false;
    }

    protected Boolean getLine(LadderGenerateStrategy ladderGenerateStrategy) {
        return ladderGenerateStrategy.isGenerating();
    }

    private boolean isFirstIndex(int index) {
        return index == 0;
    }

    public Boolean existsLadder(int index) {
        return lines.get(index);
    }

    public boolean isTransverseLadder(int index) {
        if (index % 2 == 1) {
            return existsLadder(index / 2);
        }
        return true;
    }

    public int size() {
        return lines.size();
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
