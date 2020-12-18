package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<LadderLine> ladderLines;
    private final List<Integer> result;

    public Ladder(LadderSize ladderSize) {
        this.ladderLines = IntStream.range(START_INDEX, ladderSize.getHeight())
                .mapToObj(index -> new LadderLine(ladderSize.getWidth()))
                .collect(Collectors.toList());
        this.result = start();
    }

    private List<Integer> start() {
        return IntStream.range(0, getLadderWidth())
                .mapToObj(this::get)
                .collect(Collectors.toList());
    }

    private int get(int index) {
        for (LadderLine line : ladderLines) {
            index = line.move(index);
        }
        return index;
    }

    public int getResult(int index) {
        return result.get(index);
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getLadderWidth() {
        return ladderLines.get(0).getPoints().size();
    }
}
