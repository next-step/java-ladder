package ladder2.domain;

public class LadderJudge {

    private final Players players;
    private final Prizes prizes;

    public LadderJudge(Players players, Prizes prizes) {
        this.players = players;
        this.prizes = prizes;
    }

    public void judge(LadderResult ladderResult) {
        for (int i = 0; i < players.count(); i++) {
            int resultIndex = ladderResult.resultIndexOf(i);
            Player player = players.get(i);
            Prize prize = prizes.get(resultIndex);
            player.receivePrize(prize);
        }
    }
}
