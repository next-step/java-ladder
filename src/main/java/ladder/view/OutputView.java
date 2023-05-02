package ladder.view;

import ladder.domain.LadderGame;

import java.util.List;

public class OutputView {
    private static final String BLANK = "";
    private static final String VERTICAL_LINE_STRING = "|";
    private static final String HORIZONTAL_LINE_STRING = "-";

    public void printLadder(LadderGame ladderGame) {
        System.out.println("실행결과\n");
        
        printParticipants(ladderGame.getParticipants());
        for (int i = 0; i < ladderGame.height(); i++) {
            printLine(ladderGame.checkRightConnections(i));
        }
    }

    private void printParticipants(List<String> names) {
        for (String name : names) {
            System.out.printf("%6s", name);
        }
        System.out.println();
    }

    private void printLine(List<Boolean> rightConnections) {
        System.out.printf("%6s", VERTICAL_LINE_STRING);
        for (int i = 0; i < rightConnections.size() - 1; i++) {
            String line = rightConnections.get(i) ? HORIZONTAL_LINE_STRING.repeat(5) : BLANK;
            System.out.printf("%5s%1s", line, VERTICAL_LINE_STRING);
        }
        System.out.println();
    }
}
