package nextstep.ladder.View;

import nextstep.ladder.Model.Ladder;
import nextstep.ladder.Model.Line;
import nextstep.ladder.Model.Name;
import nextstep.ladder.Model.Names;

import java.util.List;
import java.util.stream.Collectors;

public class LadderOutput {
    private static final String RESULT_TITLE = "실행 결과";
    private static final String DELIMITER = "  ";
    private static final String CONNECT_BRIDGE = "-----|";
    private static final String DIS_CONNECT_BRIDGE = "     |";

    public static void printResult(Names names, Ladder ladder) {
        System.out.println(RESULT_TITLE);
        System.out.println();
        List<Name> Names = names.getNames();
        System.out.println(Names.stream().map(Name::toString).collect(Collectors.joining(DELIMITER)));
        List<Line> Ladder = ladder.getLadder();
        for (Line line : Ladder) {
            printLine(line);
        }
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        line.getLine().forEach(it -> sb.append(convertLineInfoToString(it)));
        System.out.println(sb.toString());
    }

    private static String convertLineInfoToString(Boolean lineInfo) {
        if (lineInfo == true) {
            return CONNECT_BRIDGE;
        }
        return DIS_CONNECT_BRIDGE;
    }

}
