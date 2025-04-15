package nextstep.ladder.ui;

import nextstep.ladder.Entry;
import nextstep.ladder.Players;
import nextstep.ladder.Results;
import nextstep.ladder.line.Lines;

import java.util.Map;

public class ResultView {
    public static final String HORIZONTAL_LINE = "-----";
    public static final String VERTICAL_LINE = "|";
    public static final String EMPTY_SPACE = "     ";

    public static void printLadder(Players players, Lines lines, Results results) {
        System.out.println("\n사다리 결과\n");
        System.out.println(players);
        System.out.print(lines);
        System.out.println(results);
        System.out.println();
    }

    public static void invalidName() {
        System.out.println("\n이름을 잘못 입력하셨습니다.\n");
    }

    public static void printResult(Entry result) {
        printResultTitle();
        System.out.println(result);
        System.out.println();
    }

    public static void printResults(Map<Entry, Entry> resultsMap) {
        printResultTitle();
        for (Map.Entry<Entry, Entry> entry : resultsMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        System.out.println();
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }
}
