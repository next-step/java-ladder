package nextstep;

import java.util.List;
import java.util.Random;

public class OnlineLadder extends Ladder {
    private final int height;
    private final Coordinates coordinates;
    public static final Random RAND = new Random();

    public OnlineLadder(int height) {
        this.height = height;
        this.coordinates = new Coordinates();
    }

    public void add(String name) {
        Coordinate coordinate = new Coordinate(name, coordinates.size()+1, 0);
        this.coordinates.add(coordinate);
    }

    @Override
    public void move() {
        coordinates.move(RAND.nextInt(coordinates.size()));
    }

    public List<Integer> heights() {
        return coordinates.heights();
    }
}
