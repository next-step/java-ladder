package nextstep.ladder.domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Amounts amounts;

    public LadderGame(Players players, Ladder ladder, Amounts amounts) {
        this.players = players;
        this.ladder = ladder;
        this.amounts = amounts;
    }

    public LadderGameResult play() {
        LadderGameResult ladderGameResult = new LadderGameResult();
        for (int pointIndex = 0; pointIndex < players.size(); pointIndex++) {
            int amountIndex = ladder.movingResult(ladder.startLine(), pointIndex, 1);
            ladderGameResult.put(players.player(pointIndex), amounts.amount(amountIndex));
        }

        return ladderGameResult;
    }
}
