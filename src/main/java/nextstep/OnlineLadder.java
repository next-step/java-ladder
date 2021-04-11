package nextstep;

import java.util.List;

import static nextstep.constant.Constant.*;

public class OnlineLadder extends Ladder {
    private final int height;
    private final Coordinates coordinates;

    public OnlineLadder(int height) {
        this.height = height;
        this.coordinates = new Coordinates();
    }

    public void add(String name) {
        Coordinate coordinate = new Coordinate(name, coordinates.size()+ ADD_NUMBER, DEFAULT_HEIGHT);
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
