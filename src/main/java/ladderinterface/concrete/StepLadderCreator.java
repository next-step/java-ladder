package ladderinterface.concrete;

import ladderinterface.engine.Ladder;
import ladderinterface.engine.LadderCreator;
import ladderinterface.engine.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StepLadderCreator implements LadderCreator {

    @Override
    public Ladder create(int countOfPlayer, int height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height).forEach((i) -> lines.add(new LadderLineCreator().create(countOfPlayer)));
        return StepLadder.of(countOfPlayer, lines);
    }
}
