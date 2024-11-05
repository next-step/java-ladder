package study.core;

public class Point {
    private final int position;
    private final Edge edge;

    public Point(int position, Edge edge) {
        this.position = position;
        this.edge = edge;
    }

    public Edge getEdge() {
        return edge;
    }

    public boolean isCurrent() {
        return edge.isCurrent();
    }

    public int move() {
        if (edge.move() == Direction.RIGHT) {
            return position + 1;
        }
        if (edge.move() == Direction.LEFT) {
            return position - 1;
        }
        return position;
    }
}
