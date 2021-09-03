package newladder.model;

import java.util.List;

public class MyLine {

    private final List<Direction> directions;

    public MyLine(List<Direction> directions) {
        this.directions = directions;
    }


    public int moveLine(int position) {
        return directions.get(position).move();
    }

    public List<Direction> directionInfo() {
        return this.directions;
    }

}
