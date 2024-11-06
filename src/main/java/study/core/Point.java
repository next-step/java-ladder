package study.core;

public class Point {
    private final int position;
    private final Edge edge;

    public Point(int position, Edge edge) {
        this.position = position;
        this.edge = edge;
    }

    public static Point left(int position) {
        return new Point(position, Edge.first(true).next(false));
    }

    public static Point right(int position) {
        return new Point(position, Edge.first(false).next(true));
    }

    public static Point pass(int position) {
        return new Point(position, Edge.first(false).next(false));
    }

    public Edge getEdge() {
        return edge;
    }

    public boolean isCurrent() {
        return edge.isCurrent();
    }

    public int move() {
        if (edge.isRight()) {
            return position + 1;
        }
        if (edge.isLeft()) {
            return position - 1;
        }
        return position;
    }
}
