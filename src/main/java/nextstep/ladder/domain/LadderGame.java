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
        Line startLine = ladder.startLine();
        LadderGameResult ladderGameResult = ladder.play(players, startLine, amounts);
        return ladderGameResult;
    }
}
