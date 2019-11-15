package ladder.domain;

import java.util.Objects;

public class Line {
    private final boolean leftLink;
    private final boolean rightLink;

    private Line(final boolean leftLink, final boolean rightLink) {
        this.leftLink = leftLink;
        this.rightLink = rightLink;
    }

    public static Line ofFirst(final boolean rightLink) {
        return new Line(Boolean.FALSE, rightLink);
    }

    public static Line of(final boolean leftLink, final boolean righLink) {
        return new Line(leftLink, righLink);
    }

    public static Line ofLast(final boolean leftLink) {
        return new Line(leftLink, Boolean.FALSE);
    }

    public boolean isLeftLink() {
        return this.leftLink;
    }

    public boolean isRightLink() {
        return this.rightLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return leftLink == line.leftLink &&
                rightLink == line.rightLink;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftLink, rightLink);
    }
}
