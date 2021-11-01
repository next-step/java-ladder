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
            LineCreator lineCreator = new HeeSeokLineCreator();
            lineList.add(lineCreator.create(countOfUsers));
        }
        Lines lines = new Lines(lineList);
        return new HeeSeokLadder(lines);
    }
}
