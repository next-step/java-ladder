package ladder.domain;

import ladder.domain.strategy.LadderGeneratorStrategy;

public class Point {

    private final Boolean point;

    public Point(LadderGeneratorStrategy ladderGeneratorStrategy, int columnIndex) {
        this(ladderGeneratorStrategy.isBuild(columnIndex));
    }

    public Point(Boolean isLadder) {
        this.point = isLadder;
    }

    public boolean isLadder() {
        return point;
    }
}
