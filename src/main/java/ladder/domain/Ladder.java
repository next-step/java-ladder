package ladder.domain;

import ladder.drawable.RandomDraw;

public class Ladder {
    private final VerticalLines verticalLines;
    private final int height;

    public Ladder(Players players, int height) {
        this.verticalLines = new VerticalLines(players.getCount());
        this.height = height;
        verticalLines.drawSideLines(height, new RandomDraw());
    }

    public VerticalLines getVerticalLines() {
        return verticalLines;
    }

    public int getHeight() {
        return height;
    }
}
