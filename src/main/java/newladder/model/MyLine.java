package newladder.model;

import java.util.ArrayList;
import java.util.List;

public class MyLine{

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

    public int moveLine(int position) {
        return directionList.get(position).move();
    }

}
