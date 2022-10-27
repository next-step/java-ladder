package ladder;

import java.util.List;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_BLANK_LINE = "     ";
    private static final String HORIZONTAL_FULL_LINE = "-----";

    public static void printUserNames(List<UserName> userNames) {
        String blank = " ";
        userNames.forEach(username -> System.out.printf("%6s", username.getName() + blank));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (Row ladderRow : ladder.getLadderLines()) {
            List<Boolean> points = ladderRow.getPoints();
            for (Boolean point : points) {
                if (point) {
                    System.out.print(HORIZONTAL_FULL_LINE);
                    System.out.print(VERTICAL_LINE);
                } else {
                    System.out.print(HORIZONTAL_BLANK_LINE);
                    System.out.print(VERTICAL_LINE);
                }
            }
            System.out.println();
        }
    }
}
