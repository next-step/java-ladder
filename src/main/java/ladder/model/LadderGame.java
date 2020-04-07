package ladder.model;

public class LadderGame {

    private final LadderGameExecutionInfo ladderGameInfo;
    private final Ladder ladder;

    private LadderGame(final LadderGameExecutionInfo ladderGameInfo, final Ladder ladder) {
        validate(ladderGameInfo, ladder);
        this.ladderGameInfo = ladderGameInfo;
        this.ladder = ladder;
    }

    private void validate(LadderGameExecutionInfo ladderGameInfo, Ladder ladder) {
    }

    public static LadderGame newInstance(final LadderGameExecutionInfo ladderGameInfo, final Ladder ladder) {
        return new LadderGame(ladderGameInfo, ladder);
    }

    public LadderGameResult start() {
        LadderPoles ladderPoles = ladder.proceedAll();
        return ladderGameInfo.makeGameResult(ladderPoles);
    }
}
