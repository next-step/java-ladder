package ladder.domain.impl;

public class Tile {

    private final int position;
    private final TileType tileType;

    private Tile(int position, TileType tileType) {
        this.position = position;
        this.tileType = tileType;
    }

    public static Tile of(TileType tileType) {
        return new Tile(0, tileType);
    }

    public static Tile of(int position, TileType tileType) {
        return new Tile(position, tileType);
    }

    public static Tile first(boolean isRight) {
        return new Tile(0, TileType.first(isRight));
    }

    public Tile next(boolean isRight) {
        return new Tile(position + 1, tileType.next(isRight));
    }

    public Tile last() {
        return new Tile(position + 1, tileType.last());
    }

    public int permute() {
        return position + tileType.move();
    }
}
