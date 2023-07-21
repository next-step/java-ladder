package nextstep.ladder.domain;

import java.util.Objects;

public class Location {
    private final int height;
    private final int width;
    private final int x;
    private final int y;

    public Location(int height, int width, int x, int y) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public Location next(LadderPoints ladderPoints) {
        return this.next(ladderPoints.get(this.y, this.x - 1), ladderPoints.get(this.y, this.x));
    }

    public Location next(LadderPoint leftPoint, LadderPoint rightPoint) {
        if (leftPoint.isMovable()) {
            return new Location(this.height, this.width, x - 1, y + 1);
        }

        if (rightPoint.isMovable()) {
            return new Location(this.height, this.width, x + 1, y + 1);
        }

        return new Location(this.height, this.width, x, y + 1);
    }

    public boolean isMovable() {
        return this.x <= this.width && this.y <= this.height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return height == location.height && width == location.width && getX() == location.getX()
            && getY() == location.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, getX(), getY());
    }
}
