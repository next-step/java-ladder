package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<LadderLine> ladderLines;

    public Ladder(LadderSize ladderSize) {
        this.ladderLines = IntStream.range(START_INDEX, ladderSize.getHeight())
                .mapToObj(index -> new LadderLine(ladderSize.getWidth()))
                .collect(Collectors.toList());
    }

    public List<Integer> run() {
        return IntStream.range(0, getLadderWidth())
                .mapToObj(this::getResult)
                .collect(Collectors.toList());
    }

    private int getResult(int index) {
        for (LadderLine line : ladderLines) {
            index = line.move(index);
        }
        return index;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }

    public int getLadderWidth() {
        return ladderLines.get(0).getPoints().size();
    }

    public void printLadder() {
        getLadderLines().forEach(ladderLine -> {
            ladderLine.getPoints().forEach(point -> {
                System.out.print(String.valueOf(point.isLeft()) + '|' + point.isRight());
                System.out.print(" ");
            });
            System.out.println();
        });
    }
}
