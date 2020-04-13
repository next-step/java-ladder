package ladder.nextstep;

import ladder.engine.Ladder;
import ladder.engine.LadderCreator;
import ladder.engine.Line;
import ladder.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;

public class NextStepLadderCreator implements LadderCreator {
    private LineCreator lineCreator;

    public NextStepLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int countOfPersion, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineCreator.create(countOfPersion));
        }
        System.out.println("Line : " + lines);
        return new NextStepLadder(countOfPersion, lines);
    }
}
