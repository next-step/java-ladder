package nextstep.ladder.domain;

public class Point {
    private boolean linked;

    public Point() {
        this.linked = false;
    }

    public Point(boolean linked) {
        this.linked = linked;
    }

    public Point randomLink(LineStrategy lineStrategy, boolean previousPointLinked, boolean nextPointLinked) {
        if (!previousPointLinked && !nextPointLinked) {
            return new Point(lineStrategy.isLinkable());
        }

        return new Point();
    }

    public boolean linked() {
        return linked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return linked == point.linked;
    }

    @Override
    public int hashCode() {
        return (linked ? 1 : 0);
    }
}
