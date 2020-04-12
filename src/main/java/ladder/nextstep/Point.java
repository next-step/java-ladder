package ladder.nextstep;

class Point {
    private final int index;
    private final Direction direction;

    Point(int index, Direction direction) {
        this.index = index;
        this.direction = direction;
    }

    int move() {
        return index + direction.move();
    }

    /**
     * first와 last Point가 아닌 Point를 의미하는가?
     * first와 last Point를 제외하다보니 2를 minus
     *
     * @param people
     * @return
     */
    public boolean untilBeforeLastPoint(int people) {
        return people - 2 > index;
    }

    Point next() {
        return new Point(index + 1, direction.next());
    }

    Point next(boolean right) {
        return new Point(index + 1, direction.next(right));
    }

    boolean isLast(int maxPosition) {
        return maxPosition == this.index + 1;
    }

    static Point first(boolean right) {
        return new Point(0, Direction.first(right));
    }

    public Point last() {
        return new Point(index + 1, direction.last());
    }

    @Override
    public String toString() {
        return "Point{" +
                "index=" + index +
                ", direction=" + direction +
                '}';
    }
}