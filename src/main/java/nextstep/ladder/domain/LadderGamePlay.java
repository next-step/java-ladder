package nextstep.ladder.domain;

public class LadderGamePlay {

    private Ladder ladder;

    private LadderGamePlay(Ladder ladder) {
        this.ladder = ladder;
    }

    public static LadderGamePlay of(Ladder ladder) {
        return new LadderGamePlay(ladder);
    }

    public ExecutionResult playLadderGame(Player player, ExecutionResults executionResults) {
        Point point = player.point();
        Point result = ladder.playLadderGame(point);
        return executionResults.getExecutionResult(result);
    }
}
