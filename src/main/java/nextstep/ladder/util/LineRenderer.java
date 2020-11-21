package nextstep.ladder.util;

import java.util.function.Consumer;

public class LineRenderer {
    private final Runnable firstPartOfLine;
    private final Consumer<Boolean> point;
    private final Runnable ladderStick;
    private final Runnable lastPartOfLine;

    private LineRenderer(Builder builder) {
        firstPartOfLine = builder.firstPartOfLine;
        point = builder.point;
        ladderStick = builder.ladderStick;
        lastPartOfLine = builder.lastPartOfLine;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void renderFirstPartOfLine() {
        firstPartOfLine.run();
    }

    public void renderLastPartOfLine() {
        lastPartOfLine.run();
    }

    public Consumer<Boolean> renderPoint() {
        return point -> {
            this.point.accept(point);
            ladderStick.run();
        };
    }

    public static class Builder {
        private Runnable firstPartOfLine;
        private Consumer<Boolean> point;
        private Runnable ladderStick;
        private Runnable lastPartOfLine;

        public Builder firstPartOfLine(Runnable firstPartOfLine) {
            this.firstPartOfLine = firstPartOfLine;
            return this;
        }

        public Builder point(Consumer<Boolean> point) {
            this.point = point;
            return this;
        }

        public Builder ladderStick(Runnable ladderStick) {
            this.ladderStick = ladderStick;
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
