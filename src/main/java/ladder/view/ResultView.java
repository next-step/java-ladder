package ladder.view;

import ladder.domain.HorizontalLines;

import java.util.List;

public class ResultView {

    public static void printResultPlayer(String players) {
        System.out.println("실행 결과\n\n" + players);
    }

    public static void printResult(List<HorizontalLines> horizontalLinesList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (HorizontalLines horizontalLines : horizontalLinesList) {
            printLines(stringBuilder, horizontalLines);
        }
        System.out.println(stringBuilder.toString());
    }

    private static void printLines(StringBuilder stringBuilder, HorizontalLines horizontalLines) {
        for (Boolean horizontalLine : horizontalLines.getHorizontalLines()) {
            stringBuilder.append("|");
            if (horizontalLine) {
                stringBuilder.append("------");
                continue;
            }
            stringBuilder.append("      ");
        }
        stringBuilder.append("|\n");
    }
}
