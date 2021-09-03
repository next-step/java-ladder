package newladder.model;

import java.util.List;

public class MyLine {

    private final List<Direction> directionList;

    public MyLine(List<Direction> directionList) {
        this.directionList = directionList;
    }


    public int moveLine(int position) {
        return directionList.get(position).move();
    }

    public List<Direction> directionInfo() {
        return this.directionList;
    }

}
