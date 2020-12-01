package nextstep.ladder.view;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Point;

import java.util.function.Consumer;

public class LineRenderer {
    private final Runnable firstPartOfLine;
    private final Consumer<Point> point;
    private final Runnable lastPartOfLine;

    private LineRenderer(Builder builder) {
        firstPartOfLine = builder.firstPartOfLine;
        point = builder.point;
        lastPartOfLine = builder.lastPartOfLine;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Consumer<LadderLine> renderLine() {
        return (LadderLine line) -> {
            firstPartOfLine.run();
            line.pointsForEach(point);
            lastPartOfLine.run();
        };
    }

    public static class Builder {
        private Runnable firstPartOfLine;
        private Consumer<Point> point;
        private Runnable lastPartOfLine;

        private Builder() {

        }

        public Builder firstPartOfLine(Runnable firstPartOfLine) {
            this.firstPartOfLine = firstPartOfLine;
            return this;
        }

        public Builder point(Consumer<Point> point) {
            this.point = point;
            return this;
        }

        public Builder lastPartOfLine(Runnable lastPartOfLine) {
            this.lastPartOfLine = lastPartOfLine;
            return this;
        }

        public LineRenderer build() {
            return new LineRenderer(this);
        }
    }
}
