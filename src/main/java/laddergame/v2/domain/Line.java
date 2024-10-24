package laddergame.v2.domain;

import java.util.List;

public class Line {
    private final List<Position> positions;

    public Line(List<Position> positions) {
        this.positions = positions;
    }

    public int move(int position){
        return positions.get(position).move();
    }

    public List<Position> getPositions() {
        return positions;
    }
}
