package ladder.domain;

import ladder.drawable.RandomDraw;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final VerticalLines verticalLines;

    public Ladder(Players players, int height) {
        this.verticalLines = drawVerticalLines(players.getPlayersCount());
        drawSideLines(height, new RandomDraw());
    }

    public VerticalLines getVerticalLines() {
        return verticalLines;
    }

    private VerticalLines drawVerticalLines(int lineCount) {
        List<VerticalLine> verticalLines = new ArrayList<>();
        IntStream.rangeClosed(1, lineCount)
                .forEach(c -> verticalLines.add(new VerticalLine(c)));

        return new VerticalLines(verticalLines);
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
