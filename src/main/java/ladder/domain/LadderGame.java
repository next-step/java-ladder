package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static ladder.domain.Direction.DOWN;

public class LadderGame {

    private final Ladder ladder;
    private final Results results;

    public LadderGame(Results results, int height) {
        this.ladder = generateLadder(results.size(), height);
        this.results = results;
    }

    private Ladder generateLadder(int width, int height) {
        List<Line> lines = IntStream.range(0, height)
                .mapToObj(i -> Line.ofLength(width))
                .collect(Collectors.toList());

        return Ladder.of(lines);
    }

    public Ladder getLadder () {
        return ladder;
    }

    public Result resultOf(Player player) {
        int resultIdx = ladder.down(player.getOrderNumber());
        return results.get(resultIdx);
    }
}
