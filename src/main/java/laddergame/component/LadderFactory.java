package laddergame.component;

import laddergame.domain.Ladder;
import laddergame.domain.LadderLine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    private final LadderLineFactory ladderLineFactory;

    public LadderFactory(LadderLineFactory ladderLineFactory) {
        this.ladderLineFactory = ladderLineFactory;
    }

    public Ladder createLadder(int numberOfColumns, int height) {
        List<LadderLine> lines = IntStream.range(0, height)
                .mapToObj(i -> ladderLineFactory.createLadderLine(numberOfColumns))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

}
