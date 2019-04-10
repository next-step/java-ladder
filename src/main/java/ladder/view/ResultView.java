package ladder.view;

import ladder.domain.Ladder;

public class ResultView {

    private static final String ALL_RESULT = "all";

    public void printNames(String playerNames) {
        System.out.println(playerNames);
    }

    public void printLadder(Ladder ladder) {
        System.out.println();
        int ladderHeight = ladder.ladderHeight();
        for(int i = 0; i < ladderHeight; i++) {
            System.out.println(ladder.getLine(i).toString());
        }
    }

    public void printWinnings(String winnings) {
        System.out.println(winnings);
    }

    public void printResults(String result) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println(result);
    }
}
