package nextstep.ladder.domain;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final ResultAmounts resultAmounts;

    public LadderGame(Players players, Ladder ladder, ResultAmounts resultAmounts) {
        this.players = players;
        this.ladder = ladder;
        this.resultAmounts = resultAmounts;
    }

    public LadderResult play() {
        Line startLine = ladder.startLine();
        LadderResult ladderResult = ladder.play(players, startLine, resultAmounts);
        return ladderResult;
    }
}
