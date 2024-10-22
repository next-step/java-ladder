package ladder.service;

import ladder.domain.CreateStrategy;
import ladder.domain.Line;
import ladder.domain.Lines;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private static LadderGame INSTANCE = null;

    private LadderGame() {
    }

    public static LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public Lines createLadders(int memberSize, int height, CreateStrategy createStrategy) {
        return new Lines(IntStream.range(0, height)
                .mapToObj(num -> new Line(memberSize, createStrategy))
                .collect(Collectors.toList()));
    }

}
