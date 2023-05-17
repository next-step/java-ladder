package ladder.domain;

import ladder.exception.IllegalHorizontalLineHeightException;

import java.util.Set;
import java.util.stream.Collectors;

public class HorizontalLines {
    private final Set<HorizontalLine> horizontalLineSet;
    private final int maxHeight;

    public HorizontalLines(Set<HorizontalLine> horizontalLineSet, int maxHeight) {
        checkValidHorizontalLineHeight(horizontalLineSet, maxHeight);

        this.horizontalLineSet = horizontalLineSet;
        this.maxHeight = maxHeight;
    }

    private void checkValidHorizontalLineHeight(Set<HorizontalLine> horizontalLineSet, int maxHeight) {
        if (horizontalLineSet.stream()
                .anyMatch(it -> it.getHeight() >= maxHeight)
        ) {
            throw new IllegalHorizontalLineHeightException(String.format("최대 높이 : %d", maxHeight));
        }
    }

    public Set<HorizontalLine> getHorizontalLineSet() {
        return horizontalLineSet;
    }

    public Set<HorizontalLine> getHorizontalLineSetByHeight(int height) {
        return horizontalLineSet.stream()
                .filter(it -> it.getHeight() == height)
                .collect(Collectors.toSet());
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
