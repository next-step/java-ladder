package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Line;

public class OutputView {
    private static final String HEIGHT = "|";
    private static final String WIDTH_POINT = "-----";
    private static final String WIDTH = "     ";
    private static final String RESULT = "최대 사다리 높이는 몇 개인가요?";

    public static void resultPrint(LadderGame ladderGame) {
        System.out.println(RESULT);

        ladderGame.getUsers().forEach(user -> System.out.printf("%-7s", user.getName()));

        printLadder(ladderGame);

        System.out.printf("\n");
    }

    private static void printPoint(boolean point) {
        if (point) {
            System.out.printf(WIDTH_POINT);

            return;
        }

        System.out.printf(WIDTH);
    }

    private static void printLadder(LadderGame ladderGame) {
        for (Line line : ladderGame.getLadder().getLines()) {
            System.out.printf("\n%4s", "");

            line.getPoints().forEach(point -> {
                System.out.printf(HEIGHT);
                printPoint(point);
            });
        }
    }
}
