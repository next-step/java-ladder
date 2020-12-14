package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final LadderSize ladderSize;
    private final List<LadderLine> ladderLines;


    public Ladder(LadderSize ladderSize, LadderGenerator ladderGenerator) {
        this.ladderSize = ladderSize;
        this.ladderLines = IntStream.range(START_INDEX, ladderSize.getHeight())
                .mapToObj(index -> new LadderLine(ladderSize.getWidth(), ladderGenerator))
                .collect(Collectors.toList());
    }

    public List<Integer> run() {

        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < this.ladderSize.getWidth(); index += 2) {
            result.add(getResult(index));
        }

        return result;
    }

    private int getResult(int index) {
        for (LadderLine ladderLine : ladderLines) {
            index = ladderLine.existsSideLadder(index);
        }
        return index / 2;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
