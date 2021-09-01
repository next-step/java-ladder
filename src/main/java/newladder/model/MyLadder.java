package newladder.model;

import newladder.interfaces.Ladder;

import java.util.ArrayList;
import java.util.List;

public class MyLadder implements Ladder {

    List<MyLine> lineList = new ArrayList<>();

    public void createLadder(int userCount, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            MyLine line = new MyLine();
            line.createLine(userCount);
            lineList.add(line);
        }
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
