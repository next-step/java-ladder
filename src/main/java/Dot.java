public class Dot {
    private final Point point;
    private final DotType type;

    public Dot(Point point, DotType type) {
        this.point = point;
        this.type = type;
    }

    public int getY() {
        return this.point.getY();
    }

    public int getX() {
        return this.point.getX();
    }

    public boolean isNode() {
        return this.type == DotType.NODE;
    }

    public boolean isBridge() {
        return this.type == DotType.BRIDGE;
    }

    public int playerNumber() {
        if (this.type != DotType.NODE) {
            throw new RuntimeException();
        }

        return this.point.getX() / 2;
    }

    public Dot moveLeft() {
        return new Dot(PointCache.get(this.point.getX() - 2, this.point.getY()), this.type);
    }

    public Dot moveRight() {
        return new Dot(PointCache.get(this.point.getX() + 2, this.point.getY()), this.type);
    }

    public Dot moveDown() {
        return new Dot(PointCache.get(this.point.getX(), this.point.getY() + 1), this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;

        return this.point == dot.point && this.type == dot.type;
    }

    public String print() {
        return DotType.print(this.type);
    }
}
