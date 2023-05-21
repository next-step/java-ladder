package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String SPACE = " ";
    private static final int MAX_NAME_LENGTH = 5;
    public static final String FRONT_SPACE = "    ";
    public static final String BRIDGE_NOT_EXISTS = "     ";
    public static final String BRIDGE_EXISTS = "-----";
    public static final String LADDER_BAR = "|";

    public static final String ALL = "all";
    public static final String COLON = " : ";

    public static void printLadder(Participants participants, LadderResult results, Ladder ladder) {
        System.out.println("실행결과\n");
        participants.forEach(name -> System.out.print(nameFormat(name)));

        System.out.println();
        printLadder(ladder);
        results.forEach(result -> System.out.print(nameFormat(result)));
        System.out.println();
    }

    private static String nameFormat(String name) {
        return SPACE.repeat(MAX_NAME_LENGTH - name.length()) + name + SPACE;
    }

    private static void printLadder(Ladder ladder) {
        ladder.forEach(line ->
                System.out.println(FRONT_SPACE + drawLine(line)));
    }

    private static String drawLine(Line line) {
        return line.getPoints().stream()
                .map(OutputView::drawBridge)
                .collect(Collectors.joining(LADDER_BAR, LADDER_BAR, LADDER_BAR));
    }

    private static String drawBridge(Boolean point) {
        return point ? BRIDGE_EXISTS : BRIDGE_NOT_EXISTS;
    }

    public static void printResult(String input, Map<String, String> gameResult) {
        if (input.equals(ALL)) {
            System.out.println("실행 결과");
            gameResult.forEach((k, v) -> System.out.println(k + COLON + v));
            return;
        }
        System.out.println("실행 결과");
        System.out.println(gameResult.get(input));
    }
}
