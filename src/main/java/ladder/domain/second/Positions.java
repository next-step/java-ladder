package ladder.domain.second;

import ladder.domain.second.Position;

import java.util.List;

public class Positions {
    private List<Position> positionList;

    public Positions(List<Position> positionList) {
        this.positionList = positionList;
    }

    public void add(Position position) {
        positionList.add(position);
    }

    public Position get(int index) {
        return positionList.get(index);
    }

    public List<Position> getPositionList() {
        return positionList;
    }
}
