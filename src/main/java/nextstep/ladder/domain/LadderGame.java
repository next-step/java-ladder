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

    public LadderGameResult realPlay() {
        LadderGameResult ladderGameResult = new LadderGameResult();
        for (int index = 0; index < players.size(); index++) {
            int resultIndex = ladder.move(index);
            ladderGameResult.put(players.find(index), amounts.find(resultIndex));
        }

        return ladderGameResult;
    }
}
