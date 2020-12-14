package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<LadderLine> ladderLines;

    public Ladder(int sizeOfLadder, LadderHeight ladderHeight, LadderGenerator ladderGenerator) {
        this.ladderLines = IntStream.range(START_INDEX, ladderHeight.size())
                .mapToObj(index -> new LadderLine(sizeOfLadder, ladderGenerator))
                .collect(Collectors.toList());
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public List<Integer> run() {

        int ladderLineLength = ladderLines.get(0).getPoints().size();
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < ladderLineLength; index += 2) {
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

}
