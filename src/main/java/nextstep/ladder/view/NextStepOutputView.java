package nextstep.ladder.view;

import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.nextstep.Point;
import nextstep.ladder.domain.nextstep.NextStepLadder;
import nextstep.ladder.domain.nextstep.NextStepLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NextStepOutputView {

    private static final String SPACE = " ";
    private static final int MAX_NAME_LENGTH = 5;
    public static final String FRONT_SPACE = "    ";
    public static final String BRIDGE_NOT_EXISTS = "     ";
    public static final String BRIDGE_EXISTS = "-----";
    public static final String LADDER_BAR = "|";

    public static final String ALL = "all";
    public static final String COLON = " : ";

    public static void printLadder(Participants participants, LadderResult results, NextStepLadder ladder) {
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

    private static void printLadder(NextStepLadder ladder) {
        ladder.forEach(line ->
                System.out.println(FRONT_SPACE + drawLine((NextStepLine) line)));
    }

    private static String drawLine(NextStepLine line) {
        List<Point> points = line.getPoints();
        List<Boolean> results = new ArrayList<>();

        for (int index = 1; index < points.size(); index = index + 2) {
            List<Boolean> result = points.get(index).getDirection().get();
            results.addAll(result);
        }
        results.remove(results.size() - 1);
        return results.stream().map(NextStepOutputView::drawBridge)
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
