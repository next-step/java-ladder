package nextstep.ladder.ui;

import nextstep.ladder.common.util.ColumnPrinter;
import nextstep.ladder.common.util.RowLinePrinter;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;

import java.util.Arrays;

public class ResultView {
    private final String[] participants;
    private final Lines lines;

    public ResultView(String[] participants, Lines lines) {
        this.participants = participants;
        this.lines = lines;
    }

    public void showResult() {
        System.out.println("");
        System.out.println("실행 결과");
        printParticipants();
        printResult();
    }

    private void printParticipants() {
        Arrays.stream(participants)
                .forEach(name -> System.out.print(name + " "));
        System.out.println("");
    }

    private void printResult() {
        for (Line line : lines.getLineList()) {
            printLadderByOneLine(line);
            System.out.println("");
        }
    }

    private void printLadderByOneLine(Line line) {
        int rowLineNumber = participants.length - 1;
        System.out.print(ColumnPrinter.generate());
        for (int index = 0; index < rowLineNumber; index++) {
            if (line.isTruePosition(index)) {
                System.out.print(RowLinePrinter.generate(true) + ColumnPrinter.generate());
                continue;
            }
            System.out.print(RowLinePrinter.generate(false) + "|");
        }
    }
}
