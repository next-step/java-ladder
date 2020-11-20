package nextstep.ladder;

import nextstep.ladder.domain.Line;

import java.util.function.Consumer;

public class LineRenderer {
    private final Consumer<Boolean> renderPoints;
    private final Runnable renderLastPartOfLine;

    private LineRenderer(Consumer<Boolean> renderPoints, Runnable renderLastPartOfLine) {
        this.renderPoints = renderPoints;
        this.renderLastPartOfLine = renderLastPartOfLine;
    }

    public static LineRenderer of(Consumer<Boolean> renderPoints, Runnable renderLastPartOfLine) {
        return new LineRenderer(renderPoints, renderLastPartOfLine);
    }

    public void render(Line line) {
        line.repeatAsPoints(renderPoints);
        renderLastPartOfLine.run();
    }
}
