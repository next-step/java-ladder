package newladder.model;

import java.util.List;

public class MyLadder {

    private final List<MyLine> lines;

    public MyLadder(List<MyLine> lines) {
        this.lines = lines;
    }

    public int downLadder(int startPosition) {
        int result = startPosition;
        for (MyLine line : lines) {
            result += line.moveLine(result);
        }
        return result;
    }

    public List<MyLine> lineInfo() {
        return this.lines;
    }
}
