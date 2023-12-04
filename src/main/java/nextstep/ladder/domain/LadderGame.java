package nextstep.ladder.domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Amounts amounts;
    private final RealLadder realLadder;

    public LadderGame(Players players, Ladder ladder, Amounts amounts, RealLadder realLadder) {
        this.players = players;
        this.ladder = ladder;
        this.amounts = amounts;
        this.realLadder = realLadder;
    }

    public LadderGameResult play() {
        LadderGameResult ladderGameResult = new LadderGameResult();
        for (int pointIndex = 0; pointIndex < players.size(); pointIndex++) {
            int amountIndex = ladder.movingResult(ladder.startLine(), pointIndex, 1);
            ladderGameResult.put(players.player(pointIndex), amounts.amount(amountIndex));
        }

        return ladderGameResult;
    }

    public LadderGameResult realPlay() {
        LadderGameResult ladderGameResult = new LadderGameResult();
        for (int index = 0; index < players.size(); index++) {
            int resultIndex = realLadder.move(index);
            ladderGameResult.put(players.player(index), amounts.amount(resultIndex));
        }

        return ladderGameResult;
    }
}
