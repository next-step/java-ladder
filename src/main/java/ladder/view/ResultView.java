package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;

import java.util.List;

public class ResultView {
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        int ladderHeight = ladder.ladderHeight();
        for(int i = 0; i < ladderHeight; i++) {
            printLine(ladder.getLine(i));
            System.out.println();
        }
    }

    private void printLine(Line line) {
        int lineCount = line.lineCount();
        for(int i = 0; i < lineCount; i++) {
            System.out.print(VERTICAL_LINE);
            printHorizontalLine(line, i);
        }

    }

    private void printHorizontalLine(Line line, int index) {
        if(line.hasHorizontalLine(index)) {
            System.out.print(HORIZONTAL_LINE);
            return;
        }
        System.out.print(EMPTY_LINE);
    }
}
