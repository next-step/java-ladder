public class Dot {
    private final Point point;
    private final DotType type;

    public Dot(Point point, DotType type) {
        this.point = point;
        this.type = type;
    }

    public int calcAddX(int n) {
        return this.point.calcAddX(n);
    }

    public boolean xIs(int n) {
        return this.point.xIs(n);
    }

    public boolean yIsLowerThan(int n) {
        return this.point.yIsLowerThan(n);
    }

    public boolean isBridge() {
        return this.type == DotType.BRIDGE;
    }

    public int playerNumber() {
        if (this.type != DotType.NODE) {
            throw new RuntimeException();
        }

        return this.point.calcDivX(2);
    }

    public Dot moveLeft() {
        return new Dot(PointCache.get(this.point.calcAddX(-2), this.point.calcAddY(0)), this.type);
    }

    public Dot moveRight() {
        return new Dot(PointCache.get(this.point.calcAddX(2), this.point.calcAddY(0)), this.type);
    }

    public Dot moveDown() {
        return new Dot(PointCache.get(this.point.calcAddX(0), this.point.calcAddY(1)), this.type);
    }

    public String print() {
        return DotType.print(this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;

        return this.point == dot.point && this.type == dot.type;
    }
}
