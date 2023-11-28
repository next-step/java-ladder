package step3.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderGame {

    private final List<Line> lines;

    public LadderGame(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderGame start(final int lineHeight, final int playersCount, RandomStrategy randomStrategy) {
        List<Line> lines = Stream.generate(() -> Line.create(playersCount, randomStrategy))
                .limit(lineHeight)
                .collect(Collectors.toList());

        return new LadderGame(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }

    public int move(int playerPosition) {
        int resultIndex = playerPosition;

        for (Line line : lines) {
            resultIndex = line.move(resultIndex);
        }

        return resultIndex;
    }
}
