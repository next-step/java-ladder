package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.line.HorizontalLine;

import java.util.List;

public class Ladder {

    private final int height;
    private final List<HorizontalLine> horizontalLines;

    public Ladder(int height, List<HorizontalLine> horizontalLines) {
        this.height = height;
        this.horizontalLines = horizontalLines;
    }

    public void removeDuplicatedHorizontalLines(Ladder ladder) {
        List<HorizontalLine> horizontalLines = ladder.getHorizontalLines();

        for (int height = 0; height < this.horizontalLines.size(); height++) {
            removeIfDuplicated(this.horizontalLines.get(height), horizontalLines.get(height));
        }
    }

    private void removeIfDuplicated(HorizontalLine horizontalLine, HorizontalLine prevHorizontalLine) {
        if (horizontalLine.exist() && prevHorizontalLine.exist())
            horizontalLine.remove();
    }

    public List<HorizontalLine> getHorizontalLines() {
        return horizontalLines;
    }

    public int getHeight() {
        return height;
    }
}
