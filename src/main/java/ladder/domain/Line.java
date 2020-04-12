package ladder.domain;

import java.util.Objects;

public class Line {
    private final int height;
    private final boolean link;

    Line(int height, boolean link) {
        this.height = height;
        this.link = link;
    }

    static Line newLineOnBeforeLine(Line beforeLine) {
        if (beforeLine.link == true) {
            return new Line(beforeLine.height, false);
        }
        return new Line(beforeLine.height, new RandomLinkable().get());
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

    @Override
    public String toString() {
        return "Line{" +
                "height=" + height +
                ", link=" + link +
                '}';
    }
}
