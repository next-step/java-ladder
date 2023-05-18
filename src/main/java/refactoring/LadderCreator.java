package refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderCreator {

    private final LineGenerator lineGenerator;

    public LadderCreator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder create(final int depth, final int countOfPlayer) {
        validate(depth);
        List<Line> lines = new ArrayList<>(depth);
        IntStream.range(0, depth).forEach(i -> lines.add(lineGenerator.create(countOfPlayer)));
        return new Ladder(lines, countOfPlayer);
    }

    private static void validate(final int depth) {
        if(depth <= 0){
            throw new IllegalArgumentException("깊이는 1이상이어야 합니다.");
        }
    }
}
