package ladder.ladder.domain;

import java.util.Objects;

public class Line {
    private final int height;
    private final boolean link;

    private Line(int height, boolean link) {
        this.height = height;
        this.link = link;
    }

    public static Line of(int height, boolean link) {
        return new Line(height, link);
    }

    public static Line generateLineBasedPrevLine(Line beforeLine, boolean link) {
        if (beforeLine.link == true) {
            return new Line(beforeLine.height, false);
        }
        return new Line(beforeLine.height, link);
    }

    public int getHeight() {
        return height;
    }

    public boolean isLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return height == line.height &&
                link == line.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, link);
    }

}
