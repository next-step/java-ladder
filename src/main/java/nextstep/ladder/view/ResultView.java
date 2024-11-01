package nextstep.ladder.view;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() {

    }

    public static void printLadderStatus(List<String> names, String ladder, List<String> results) {
        System.out.println("\n사다리 결과\n");
        printNames(names);
        System.out.print(ladder);
        printPlayResults(results);
    }

    private static void printNames(List<String> names) {
        for (int cnt = 0; cnt < names.size(); cnt++) {
            System.out.printf("%-6s", names.get(cnt));
        }
        System.out.println();
    }

    private static void printPlayResults(List<String> results) {
        for (int cnt = 0; cnt < results.size(); cnt++) {
            System.out.printf("%-6s", results.get(cnt));
        }
        System.out.println();
    }

    public static void printResult(String result) {
        System.out.println("\n실행결과");
        System.out.println(result);
    }

    public static void printAllResult(Map<String, String> results) {
        System.out.println("\n실행결과");
        for (String name : results.keySet()) {
            System.out.printf("%s : %s\n", name, results.get(name));
        }
    }
}
