package nextstep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.constant.Constant.*;

public class OnlineLadder extends Ladder {
    private final int height;
    private final Coordinates coordinates;
    private final List<Line> lines;

    public OnlineLadder(int height) {
        this.height = height;
        this.coordinates = new Coordinates();
        this.lines = new ArrayList<>();
    }

    public OnlineLadder(int height, Coordinates coordinates, int countOfPerson) {
        this.height = height;
        this.coordinates = coordinates;
        this.lines = new ArrayList<>(countOfPerson);
        for (int i = 0; i <= countOfPerson; i++) {
            this.lines.add(new Line(countOfPerson));
        }
    }

    public void add(String name) {
        Coordinate coordinate = new Coordinate(name, coordinates.size()+ ADD_NUMBER, DEFAULT_HEIGHT);
        this.coordinates.add(coordinate);
    }

    @Override
    public void move() {
        coordinates.move(RAND.nextInt(coordinates.size()));
    }

    public void lineMark(int height, int target) {
        this.lines.get(height).mark(target);
    }

    public List<Integer> heights() {
        return coordinates.heights();
    }

    public String ladderString(int targetHeight) {
        return this.lines.get(targetHeight).lineString();
    }
}
