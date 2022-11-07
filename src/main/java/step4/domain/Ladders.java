package step4.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladders {
    private static final String HEIGHT_EXCEPTION = "사다리의 높이는 1이상이어야 합니다.";

    private final int height;
    private final int ladderCounts;
    private final List<LadderLevel> ladderLevels;

    public Ladders(int height, int userCounts, LineConditional conditional) {
        validateHeight(height);
        this.height = height;
        this.ladderCounts = userCounts - 1;
        this.ladderLevels = createLadderLevels(conditional);
    }

    private void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(HEIGHT_EXCEPTION);
        }
    }

    private List<LadderLevel> createLadderLevels(LineConditional conditional) {
        List<LadderLevel> lines = new ArrayList<>();
        for (int i = 0; i < this.height; i++) {
            lines.add(new LadderLevel(createLevelLines(conditional)));
        }
        return lines;
    }

    private List<Line> createLevelLines(LineConditional conditional) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < this.ladderCounts; i++) {
            lines.add(new Line(canHaveLine(lines, i, conditional)));
        }
        return lines;
    }

    private boolean canHaveLine(List<Line> lines, int i, LineConditional conditional) {
        if (i > 0 && lines.get(i - 1).isLine()) {
            return false;
        }
        return conditional.canHaveLine(i);
    }

    public Map<Integer, Integer> getOneResultIndex(int startIndex) {
        Map<Integer, Integer> results = new HashMap<>();
        int currentIndex = startIndex;
        for (LadderLevel level : this.ladderLevels) {
            currentIndex = level.getDirection(currentIndex);
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

    public List<LadderLevel> ladderLevels() {
        return new ArrayList<>(ladderLevels);
    }
}
