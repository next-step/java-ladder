package nextstep;

import java.util.List;
import java.util.Random;

public class OnlineLadder extends Ladder {
    private final int height;
    private final Coordinates coordinates;

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
        Random rand = new Random();
        coordinates.move(rand.nextInt(coordinates.size()));
    }

    public List<Integer> heights() {
        return coordinates.heights();
    }
}
