package newladder.model;

import newladder.interfaces.Line;

import java.util.ArrayList;
import java.util.List;

public class MyLine implements Line {

    private final List<Direction> directionList = new ArrayList<>();

    public void createLine(int userCount) {
        Direction direction = new Direction();
        directionList.add(direction);

        while (beforeLastDirection(userCount)) {
            direction = direction.next();
            directionList.add(direction);
        }

        directionList.add(direction.last());
    }


    private boolean beforeLastDirection(int userCount) {
        return directionList.size() < userCount - 1;
    }


    @Override
    public int moveLine(int position) {
        return directionList.get(position).move();
    }

    public List<Direction> directionInfo() {
        return this.directionList;
    }
}
