package step3.domain;

import java.util.*;

public class Ladder {
    private static final String HEIGHT_EXCEPTION = "사다리의 높이는 1이상이어야 합니다.";

    private final int height;
    private final List<Lines> ladders;

    public Ladder(int height, int userCounts, LineConditional conditional) {
        validateHeight(height);
        this.height = height;
        this.ladders = createLadder(userCounts, conditional);
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(HEIGHT_EXCEPTION);
        }
    }

    private List<Lines> createLadder(int userCounts, LineConditional conditional) {
        List<Lines> lines = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            lines.add(new Lines(createLadderLine(userCounts, conditional)));
        }
        return lines;
    }

    private List<Boolean> createLadderLine(int userCounts, LineConditional conditional) {
        List<Boolean> lines = new ArrayList<>();
        for (int i = 0; i < userCounts - 1; i++) {
            lines.add(canHaveLine(lines, i, conditional));
        }
        return lines;
    }

    private boolean canHaveLine(List<Boolean> lines, int i, LineConditional conditional) {
        if (i > 0 && lines.get(i - 1)) {
            return false;
        }
        return conditional.canHaveLine(i);
    }

    public Map<Integer, Integer> getOneResultIndex(int startIndex) {
        Map<Integer, Integer> results = new HashMap<>();
        int currentIndex = startIndex;
        for (Lines ladder : this.ladders) {
            currentIndex = ladder.getDirection(currentIndex);
        }
        results.put(startIndex, currentIndex);
        return results;
    }

    public Map<Integer, Integer> getAllResultIndex(int userCounts) {
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < userCounts; i++) {
            results.putAll(getOneResultIndex(i));
        }
        return results;
    }

    public List<Lines> getLines() {
        return ladders;
    }
}
