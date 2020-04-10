package ladder.model;

import java.util.Objects;

public class LadderGame {

    private final LadderGameExecutionInfo ladderGameInfo;
    private final Ladder ladder;

    private LadderGame(final LadderGameExecutionInfo ladderGameInfo, final Ladder ladder) {
        validate(ladderGameInfo, ladder);
        this.ladderGameInfo = ladderGameInfo;
        this.ladder = ladder;
    }

    private void validate(LadderGameExecutionInfo ladderGameInfo, Ladder ladder) {
        if (Objects.isNull(ladderGameInfo) || Objects.isNull(ladder)) {
            throw new IllegalArgumentException("LadderGameExecutionInfo and Ladder must be existed.");
        }
    }

    public static LadderGame newInstance(final LadderGameExecutionInfo ladderGameInfo, final Ladder ladder) {
        return new LadderGame(ladderGameInfo, ladder);
    }

    public LadderGameResult start() {
        return ladderGameInfo.makeGameResult(ladder.proceedAll());
    }

    public LadderGameExecutionInfo getLadderGameInfo() {
        return ladderGameInfo;
    }

    public Ladder getLadder() {
        return ladder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderGame)) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(getLadderGameInfo(), that.getLadderGameInfo()) &&
                Objects.equals(getLadder(), that.getLadder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLadderGameInfo(), getLadder());
    }
}
