package ladder2.domain;

public class LadderJudge {

    private final Players players;
    private final Prizes prizes;

    public LadderJudge(Players players, Prizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public void judge(LadderResult ladderResult) {
        for (int playerIndex = 0; playerIndex < players.count(); playerIndex++) {
            int prizeIndex = ladderResult.resultIndexOf(playerIndex);
            players.sendPrize(playerIndex, prizes.get(prizeIndex));
        }
    }
}
