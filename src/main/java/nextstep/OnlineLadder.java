package nextstep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class OnlineLadder implements Ladder {
    protected final List<Coordinate> coordinates;
    private final int height;

    public OnlineLadder(int height) {
        this.height = height;
        this.coordinates = new ArrayList<>();
    }

    public void add(String name) {
        Coordinate coordinate = new Coordinate(name, coordinates.size()+1, 0);
        this.coordinates.add(coordinate);
    }

    @Override
    public void move() {
        Random rand = new Random();
        coordinates.get(rand.nextInt(coordinates.size())).move();
    }

    public List<Integer> heights() {
        return coordinates.stream()
                .map(Coordinate::getHeight)
                .collect(Collectors.toList());
    }
}
