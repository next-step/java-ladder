package laddergame.ui;

import laddergame.ladder.LadderLine;
import laddergame.user.UserName;

import java.util.List;

public class ResultView {

    private static final String END_OF_LADDER_LINE = "|";
    private static final String CONNECTED_LADDER_LINE = "|-----";
    private static final String NOT_CONNECTED_LADDER_LINE = "|     ";

    public void showResult(List<UserName> userNames, List<LadderLine> ladderLines) {
        showTitle();
        showNames(userNames);
        showLines(ladderLines);
    }

    private void showTitle() {
        System.out.println("실행결과");
    }

    private void showNames(List<UserName> userNames) {
        userNames.forEach(name -> System.out.print(name.value() + " "));
        System.out.println();
    }

    private void showLines(List<LadderLine> ladderLines) {
        ladderLines.forEach(line -> {
            line.points().forEach(this::drawConnection);
            System.out.println(END_OF_LADDER_LINE);
        });
    }

    private void drawConnection(boolean point) {
        if (point) {
            System.out.print(CONNECTED_LADDER_LINE);
            return;
        }
        System.out.print(NOT_CONNECTED_LADDER_LINE);
    }
}
