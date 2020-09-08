package step04.model;

public class Ladder {

    private static final String INVALID_STATE = "사다리가 생성되지 않아 경로를 탐색할 수 없습니다!";

    private final LadderHeight ladderHeight;
    private LadderLines ladderLines;

    public Ladder(LadderHeight ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public void setLadderLines(int userNum, LadderMakeStrategy ladderMakeStrategy) {
        this.ladderLines = LadderLines.of(ladderHeight.getLineNum(),
                userNum, ladderMakeStrategy);
    }

    public RouteInfo<Integer> getNavigateResult() {
        return ladderLines.getRouteInfo();
    }

    public String printableLadderStatus() {
        return ladderLines.getPrintableString();
    }
}
