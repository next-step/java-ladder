package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderEdge;
import ladder.domain.LadderGame;
import ladder.domain.Player;

public class ResultView {
    private final static String PRINT_LADDER_RESULT = "사다리 결과";
    private final static String PRINT_RESULT = "실행결과";
    public final static int AISLE_WIDTH = 6;

    public static void printLadder(Ladder ladder, LadderEdge ladderEdge) {
        System.out.println(PRINT_LADDER_RESULT);
        StringBuilder sb = new StringBuilder();
        sb.append(ladderEdge.getAllPlayer()).append(System.lineSeparator());
        sb.append(ladder.printLadder());
        sb.append(ladderEdge.getAllReward()).append(System.lineSeparator());
        System.out.println(sb);
    }

    public static void printResult(String findResult, LadderGame ladderGame) {
        System.out.println(PRINT_RESULT);
        if (findResult.equals("all")) {
            printResultAll(ladderGame);
            return;
        }
        System.out.println(ladderGame.findReward(new Player(findResult)));
    }

    private static void printResultAll(LadderGame ladderGame) {
        ladderGame.gameResult()
                .keySet()
                .forEach(key -> System.out.println(
                        String.format("%s : %s", key, ladderGame.findReward(key))));
    }

}
