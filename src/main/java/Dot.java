public class Dot {
    private int x;
    private int y;
    private DotType type;

    public Dot(int x, int y, DotType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public int playerNumber() {
        if (this.type != DotType.NODE) {
            throw new RuntimeException();
        }

        return this.x / 2;
    }

    public Dot moveLeft() {
        return new Dot(this.x - 2, this.y, this.type);
    }

    public Dot moveRight() {
        return new Dot(this.x + 2, this.y, this.type);
    }

    public Dot moveDown() {
        return new Dot(this.x, this.y + 1, this.type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;

        return x == dot.x && y == dot.y && type == dot.type;
    }
}
