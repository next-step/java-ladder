package ladder.model;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<LadderLine> lines;

    public Ladder(int width, int height) {
        this(new Random(), width, height);
    }

    public Ladder(Random random, int width, int height) {
        this.lines = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.genRandomLadderLine(width, random))
                .collect(Collectors.toList());
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public int getHeight() {
        return this.lines.size();
    }

    public int run(int startIndex) {
        int currentIndex = startIndex;

        for (LadderLine line : lines) {
            currentIndex = getNextIndex(line, currentIndex);
        }

        return currentIndex;
    }

    private int getNextIndex(LadderLine line, int index) {
        return index + line.getOffset(index);
    }

}
