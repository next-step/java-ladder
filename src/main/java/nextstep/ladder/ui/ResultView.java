package nextstep.ladder.ui;

import nextstep.ladder.Name;
import nextstep.ladder.Names;
import nextstep.ladder.line.Lines;

import java.util.Map;

public class ResultView {
    public static final String HORIZONTAL_LINE = "-----";
    public static final String VERTICAL_LINE = "|";
    public static final String EMPTY_SPACE = "     ";

    public static void printLadder(Names players, Lines lines, Names results) {
        System.out.println("\n사다리 결과\n");
        System.out.println(players);
        System.out.print(lines);
        System.out.println(results);
        System.out.println();
    }

    public static void invalidName() {
        System.out.println("\n이름을 잘못 입력하셨습니다.\n");
    }

    public static void printResult(Name result) {
        printResultTitle();
        System.out.println(result);
        System.out.println();
    }

    public static void printResults(Map<Name, Name> resultsMap) {
        printResultTitle();
        for (Map.Entry<Name, Name> entry : resultsMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }
}
