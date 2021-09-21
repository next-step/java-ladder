package nextstep.ladder.model;

import nextstep.ladder.model.api.Ladder;
import nextstep.ladder.model.api.LadderBuilder;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LineLadderBuilder implements LadderBuilder {
    private final DrawStrategy drawStrategy;

    public LineLadderBuilder(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    @Override
    public Ladder build(int width, int height) {
        Lines lines = new Lines(
            IntStream.range(0, width - 1).mapToObj(unused -> new Line(height)).collect(Collectors.toList())
        );
        drawSteps(lines);

        return new LineLadder(lines);
    }

    private void drawSteps(Lines lines) {
        for (int width = Lines.MIN_WIDTH; lines.hasRightLine(width); width++) {
            lines.getRightLine(width).drawSteps(drawStrategy, lines.hasLeftLine(width) ? lines.getLeftLine(width) : null);
        }
    }
}
