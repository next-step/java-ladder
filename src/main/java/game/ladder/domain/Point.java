package game.ladder.domain;

/**
 * Created by yusik on 2019/11/10.
 */
public class Point {

    private boolean linkable;

    private Point(boolean linkable) {
        this.linkable = linkable;
    }

    public static Point of(boolean movable) {
        return new Point(movable);
    }

    public boolean isLinkable() {
        return linkable;
    }

    public Point createNextPoint(LinkStrategy linkStrategy) {
        return isLinkable() ? Point.of(false) : Point.of(linkStrategy.isLinkable());
    }

    @Override
    public String toString() {
        return String.valueOf(linkable);
    }
}
