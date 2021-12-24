package ladderinterface.concrete;

import ladderinterface.engine.Ladder;
import ladderinterface.engine.LadderCreator;
import ladderinterface.engine.Line;
import ladderinterface.engine.LineCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StepLadderCreator implements LadderCreator {
    private final LineCreator lineCreator;

    public StepLadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    @Override
    public Ladder create(int countOfPlayer, int height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height).forEach((i) -> lines.add(lineCreator.create(countOfPlayer)));
        return StepLadder.of(countOfPlayer, lines);
    }
}
