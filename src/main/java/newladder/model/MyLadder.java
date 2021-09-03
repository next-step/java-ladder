package newladder.model;

import java.util.List;

public class MyLadder {

    private final List<MyLine> lineList;

    public MyLadder(List<MyLine> lineList) {
        this.lineList = lineList;
    }

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
