package step04.model;

public class Ladder {

    private final LadderHeight ladderHeight;
    private LadderLines ladderLines;

    public Ladder(LadderHeight ladderHeight) {
        this.ladderHeight = ladderHeight;
    }

    public static Ladder withLines(Ladder ladder, int userNum, LadderMakeStrategy ladderMakeStrategy) {
        ladder.setLadderLines(userNum, ladderMakeStrategy);

        return ladder;
    }

    private void setLadderLines(int userNum, LadderMakeStrategy ladderMakeStrategy) {
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
