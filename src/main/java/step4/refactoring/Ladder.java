package step4.refactoring;

import step4.domain.MatchingResult;
import step4.domain.Player;
import step4.domain.Players;
import step4.domain.WinningPrizes;
import step4.strategy.LineStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<LadderLine> lines;

    private Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    public static Ladder of(Players players, int laddersHeight, LineStrategy lineStrategy) {
        return (Ladder) Stream.generate(() -> LadderLine.init(players.size(), lineStrategy))
                .limit(laddersHeight)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::new));
    }

    public List<LadderLine> getLines() {
        return lines;
    }

    public MatchingResult calculateWinningPrizeLine(Players players, WinningPrizes winningPrizes) {
        HashMap<Player, String> result = new HashMap<>();
        // calc matching prize
        for (int i = 0; i < players.size(); i++) {
            result.put(players.get(i), winningPrizes.get(findResultPosition(i)));
        }
        return new MatchingResult(result);
    }

    private int findResultPosition(int playerPosition) {
        for (LadderLine line : lines) {
            playerPosition = line.move(playerPosition);
        }
        return playerPosition;
    }

}
