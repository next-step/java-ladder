package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLineGenerator {
    private static final Random random = new Random();

    public static LadderLines generateLadderLines(int height, int size) {
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladderLines.add(generateLadderLine(size));
        }

        return new LadderLines(ladderLines);
    }

    private static LadderLine generateLadderLine(int size) {
        List<Boolean> lines = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            boolean prev = i != 0 && lines.get(i - 1);

            boolean cur = !prev && random.nextBoolean();
            lines.add(cur);
        }

        return new LadderLine(lines);
    }
}
