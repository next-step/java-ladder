package nextstep.ladder.view;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Lines;
import nextstep.ladder.domain.participant.Participants;

public class OutputView {
    private static String BLANK = "   ";
    private static String LADDER_COLUMN = "|";
    private static String LADDER_TRUE_ROW = "------";
    private static String LADDER_FALSE_ROW = "      ";


    private OutputView() {
    }

    public static void printResult(Participants participants, Lines lines) {
        System.out.println("실행결과");
        System.out.println();

        participants.getNames()
                .stream()
                .map(name -> BLANK + name)
                .forEach(System.out::print);
        System.out.println();

        lines.getLines()
                .forEach(OutputView::printOneLine);
    }

    private static void printOneLine(Line line) {
        line.getLine()
                .forEach(point -> {
                            System.out.print(point ? LADDER_TRUE_ROW : LADDER_FALSE_ROW);
                            System.out.print(LADDER_COLUMN);
                        }
                );

        System.out.println();
    }
}
