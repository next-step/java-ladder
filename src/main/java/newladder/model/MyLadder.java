package newladder.model;

import newladder.interfaces.Ladder;

import java.util.ArrayList;
import java.util.List;

public class MyLadder implements Ladder {

    private final List<MyLine> lineList;

    public MyLadder(List<MyLine> lineList) {
        this.lineList = lineList;
    }

    @Override
    public int downLadder(int startPosition) {
        int result = startPosition;
        for (MyLine line : lineList) {
            result += line.moveLine(result);
        }
        return result;
    }

    public List<MyLine> lineInfo() {
        return this.lineList;
    }
}
