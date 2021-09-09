package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LadderGameMain {

    private final Ladder ladder;
    private final Players players;
    private final LadderGamePrizes ladderGamePrizes;

    public LadderGameMain(LadderGameSettings gameSettings) {
        this.ladder = Ladder.from(gameSettings.getDrawingSettings());
        this.players = gameSettings.getPlayers();
        this.ladderGamePrizes = gameSettings.getLadderGamePrizes();
    }

    public LadderGameResult playGame() {
        rideLadderSteps();
        return LadderGameResult.from(players, ladderGamePrizes);
    }

    private void rideLadderSteps() {
        List<LadderStep> ladderSteps = ladder.getLadderSteps();
        for (LadderStep ladderStep : ladderSteps) {
            swapPlayerOrder(ladderStep);
        }
    }

    private void swapPlayerOrder(LadderStep ladderStep) {
        InterSpaces interSpaces = ladderStep.getInterSpaces();

        IntStream.range(0, interSpaces.count())
            .filter(i -> interSpaces.hasCrossLineAt(i))
            .forEach(i -> players.swap(i, i + 1));
    }

    public Ladder getLadder() {
        return ladder;
    }
}
