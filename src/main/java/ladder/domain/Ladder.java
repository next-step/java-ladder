package ladder.domain;

import ladder.drawable.RandomDraw;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final VerticalLines verticalLines;
    private final int height;

    public Ladder(Players players, int height) {
        this.verticalLines = new VerticalLines(players.getPlayersCount());
        this.height = height;
        drawSideLines(height, new RandomDraw());
    }

    public List<VerticalLine> getVerticalLines() {
        return verticalLines.getVerticalLines();
    }

    public int getHeight() {
        return height;
    }

    private void drawSideLines(int height, RandomDraw randomDraw) {
        for (int i = 1; i < verticalLines.getSize(); i++) {
            VerticalLine verticalLine = verticalLines.getLine(i);
            IntStream.rangeClosed(1, height)
                    .forEach(h -> drawSideLine(verticalLine, h, randomDraw));
        }
    }

    private void drawSideLine(VerticalLine verticalLine, int height, RandomDraw randomDraw) {
        if (randomDraw.isDraw() && !verticalLine.isExistLine(height)) {
            verticalLines.drawSideLine(verticalLine, height);
        }
    }
}
