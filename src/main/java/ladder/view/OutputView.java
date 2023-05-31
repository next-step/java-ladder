package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.LadderGame;
import ladder.domain.LadderResultPrint;
import ladder.domain.Line;
import ladder.domain.PrintDelegator;

public class OutputView {

    private static final String SPACE = " ";
    private static final String FIRST_SPACE = "    ";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_NOT_EXIST = "     ";
    private static final String LADDER_BAR = "|";

    public static void print(LadderGame ladderGame) {
        System.out.println("실행결과");
        ladderGame.getParticipants().forEach(name -> System.out.print(stringFormatting(name.getName())));

        System.out.println();
        printLadder(ladderGame.getLines());

        ladderGame.getResults().forEach(result -> System.out.print(stringFormatting(result.getResult())));
        System.out.println();
    }

    public static void selectResultPrint(List<LadderResultPrint> results) {
        System.out.println("실행결과");

        if (results.size() != 1) {
            results.stream().map(result -> result.getParticipantName() + " : " + result.getResult()).forEach(System.out::println);
            return;
        }

        System.out.println(results.get(0).getResult());

    }

    private static String stringFormatting(String name) {
        return String.format("%5s", name) + SPACE;
    }

    private static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(FIRST_SPACE + printLine(line));
        }
    }

    private static String printLine(Line line) {
        return line.getPoints().stream().map(predict -> predict ? BRIDGE_EXIST : BRIDGE_NOT_EXIST)
                .collect(Collectors.joining(LADDER_BAR, LADDER_BAR, LADDER_BAR));

    }

}
