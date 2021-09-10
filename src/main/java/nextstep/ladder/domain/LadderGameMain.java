package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.strategy.RandomDrawLineStrategy;

public class LadderGameMain {

    private final Ladder ladder;
    private final Players players;
    private final LadderGamePrizes ladderGamePrizes;

    private LadderGameMain(LadderGameSettings gameSettings) {
        this.ladder = Ladder.from(gameSettings, RandomDrawLineStrategy.getInstance());
        this.players = gameSettings.getPlayers();
        this.ladderGamePrizes = gameSettings.getLadderGamePrizes();
    }

    public static LadderGameMain initialize(LadderGameSettings gameSettings) {
        LadderGameMain gameMain = new LadderGameMain(gameSettings);
        gameMain.play();
        return gameMain;
    }

    public LadderGameResult getGameResult() {
        return LadderGameResult.from(players, ladderGamePrizes);
    }

    private void play() {
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
