package ladder;

public class OutputView {
    private final LadderGame ladderGame;

    public OutputView (LadderGame ladderGame) {
        this.ladderGame = ladderGame;
    }

    public void printResult() {
        System.out.println("사다리 결과:");
        ladderGame.printLadder();
    }

}
