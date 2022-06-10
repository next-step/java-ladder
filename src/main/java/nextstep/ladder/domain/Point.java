package nextstep.ladder.domain;

public class Point {
    private boolean linked;
    public Point() {
        this.linked = false;
    }

    public Point(boolean linked) {
        this.linked = linked;
    }

    public Point next(LineStrategy lineStrategy) {
        if (linked) {
            return unlink();
        }
        return new Point(lineStrategy.isLinkable());
    }

    private Point unlink() {
        return new Point(false);
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
