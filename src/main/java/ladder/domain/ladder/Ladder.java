package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.LadderResult;
import ladder.domain.result.LadderResults;
import ladder.domain.result.MatchResult;
import ladder.domain.strategy.LineStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    public static final int LEAST_HEIGHT = 0;
    private static final int LEAST_WIDTH = 2;

    private final List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(int countOfPerson, int ladderHeight, LineStrategy lineStrategy) {
        validate(countOfPerson, ladderHeight);
        return Stream.generate(() -> LadderLine.of(countOfPerson, lineStrategy))
                .limit(ladderHeight)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    private static void validate(int countOfPerson, int ladderHeight) {
        if (countOfPerson < LEAST_WIDTH) {
            throw new IllegalArgumentException("Ladder width must be larger than 1.");
        }
        if (ladderHeight < LEAST_HEIGHT) {
            throw new IllegalArgumentException("Ladder height must be positive.");
        }
    }

    public MatchResult getGameResult(Players players, LadderResults ladderResults) {
        Map<Player, LadderResult> result = new HashMap<>();
        for (int i = 0; i < players.getCountOfPerson(); i++) {
            result.put(players.get(i), ladderResults.get(findResultPosition(i)));
        }
        return new MatchResult(result);
    }

    private int findResultPosition(int playerPosition) {
        for (LadderLine line : lines) {
            playerPosition = line.move(playerPosition);
        }
        return playerPosition;
    }

    public List<LadderLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
