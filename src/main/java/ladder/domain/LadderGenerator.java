package ladder.domain;

import ladder.exception.IllegalLadderParameterException;

import java.util.HashSet;
import java.util.Set;

public class LadderGenerator {
    private static final double DEFAULT_CHANCE = 0.5;

    private final LadderGenerateStrategy ladderGenerateStrategy;

    public LadderGenerator() {
        this.ladderGenerateStrategy = () -> Math.random() < DEFAULT_CHANCE;
    }

    public LadderGenerator(LadderGenerateStrategy ladderGenerateStrategy) {
        this.ladderGenerateStrategy = ladderGenerateStrategy;
    }

    public Ladder generate(int height, int width) {
        checkHeightAndWidth(height, width);

        VerticalLines verticalLines = VerticalLines.create(width);
        HorizontalLines horizontalLines = createHorizontalLines(verticalLines, height);

        return new Ladder(verticalLines, horizontalLines);
    }

    private HorizontalLines createHorizontalLines(VerticalLines verticalLines, int height) {
        HashSet<HorizontalLine> horizontalLineHashSet = new HashSet<>();

        for (int i = 0; i < height; i++) {
            Set<HorizontalLine> sameHeightHorizontalLineSet = createSameHeightHorizontalLineSet(verticalLines, i);
            horizontalLineHashSet.addAll(sameHeightHorizontalLineSet);
        }

        return new HorizontalLines(horizontalLineHashSet, height);
    }

    private Set<HorizontalLine> createSameHeightHorizontalLineSet(VerticalLines verticalLines, int height) {
        HashSet<HorizontalLine> sameHeightHorizontalLineHashSet = new HashSet<>();

        for (int i = 0; i < verticalLines.getMaxWidth() - 1; i++) {
            VerticalLine nowVerticalLine = verticalLines.getVerticalLineByIndex(i);
            VerticalLine nextVerticalLine = verticalLines.getVerticalLineByIndex(i + 1);

            boolean notExistPreviousHorizontalLine = sameHeightHorizontalLineHashSet.stream()
                    .noneMatch(horizontalLine ->
                            horizontalLine.getRightVerticalLine() == nowVerticalLine
                    );

            if (notExistPreviousHorizontalLine && ladderGenerateStrategy.canGenerate()) {
                sameHeightHorizontalLineHashSet.add(
                        new HorizontalLine(
                                new AdjacentVerticalLines(nowVerticalLine, nextVerticalLine),
                                height
                        )
                );
            }
        }
        return sameHeightHorizontalLineHashSet;
    }

    private void checkHeightAndWidth(int height, int width) {
        if (height < HorizontalLine.MINIMUM_HEIGHT
                || width < Ladder.MINIMUM_VERTICAL_LINES_QUANTITY) {
            throw new IllegalLadderParameterException(String.format("입력된 높이 : %d, 입력된 너비 : %d", height, width));
        }
    }
}
