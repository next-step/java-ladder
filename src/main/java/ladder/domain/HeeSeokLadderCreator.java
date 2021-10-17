package ladder.domain;

import ladder.engine.Ladder;
import ladder.engine.LadderCreator;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class HeeSeokLadderCreator implements LadderCreator {
    private LineCreator lineCreator;

    public HeeSeokLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder make(int height, int countOfUsers) {
        List<Line> lineList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line newLine = new Line(countOfUsers);
            newLine.drawOneLine();
            lineList.add(newLine);
        }
        Lines lines = new Lines(lineList);
        return new HeeSeokLadder(lines);
    }
}
