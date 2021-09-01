package newladder.model;

import newladder.interfaces.Line;

import java.util.ArrayList;
import java.util.List;

public class MyLine implements Line {

    private final List<Direction> directionList;

    public MyLine(List<Direction> directionList) {
        this.directionList = directionList;
    }

    @Override
    public int moveLine(int position) {
        return directionList.get(position).move();
    }

    public List<Direction> directionInfo() {
        return this.directionList;
    }

}
