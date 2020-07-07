package ladder.domain;

import ladder.util.StringUtil;

import java.util.List;

public class LadderCompensation {
    private final List<String> ladderCompensations;

    public LadderCompensation(String stringLadderCompensations) {
        this.ladderCompensations = StringUtil.parse(stringLadderCompensations);
    }

    public int getNumberOfCompensation() {
        return ladderCompensations.size();
    }

    public String getCompensation(final int index) {
        final int maxIndex = ladderCompensations.size() - 1;
        if (index > maxIndex) {
            throw new IllegalArgumentException();
        }
        return ladderCompensations.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ladderCompensations.forEach((compensation) -> stringBuilder.append(StringUtil.fixStringLength(compensation)));
        return stringBuilder.toString();
    }

}
