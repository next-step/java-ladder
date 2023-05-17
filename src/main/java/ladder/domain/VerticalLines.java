package ladder.domain;

import ladder.exception.IllegalVerticalLineWidthException;

import java.util.HashSet;
import java.util.Set;

public class VerticalLines {
    private final Set<VerticalLine> verticalLineSet;
    private final int maxWidth;

    public VerticalLines(Set<VerticalLine> verticalLineSet, int maxWidth) {
        checkValidVerticalLineWidth(verticalLineSet, maxWidth);

        this.verticalLineSet = verticalLineSet;
        this.maxWidth = maxWidth;
    }

    private void checkValidVerticalLineWidth(Set<VerticalLine> verticalLineSet, int maxWidth) {
        if (verticalLineSet.stream()
                .anyMatch(it -> it.getIndex() >= maxWidth)
        ) {
            throw new IllegalVerticalLineWidthException(String.format("최대 너비 : %d", maxWidth));
        }
    }

    public Set<VerticalLine> getVerticalLineSet() {
        return Set.copyOf(verticalLineSet);
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public VerticalLine getVerticalLineByIndex(int index) {
        return verticalLineSet.stream()
                .filter(it -> it.getIndex() == index)
                .findFirst()
                .orElse(null);
    }

    public int getSize() {
        return verticalLineSet.size();
    }

    public static VerticalLines create(int count) {
        HashSet<VerticalLine> verticalLineHashSet = new HashSet<>();
        for (int i = 0; i < count; i++) {
            verticalLineHashSet.add(new VerticalLine(i));
        }
        return new VerticalLines(verticalLineHashSet, count);
    }
}
