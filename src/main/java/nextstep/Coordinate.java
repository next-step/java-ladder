package nextstep;

public class Coordinate {
    private final int width;
    private int height;

    public Coordinate(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return width == that.width && height == that.height;
    }

    public int getHeight() {
        return height;
    }

    public void move() {
        this.height++;
    }
}
