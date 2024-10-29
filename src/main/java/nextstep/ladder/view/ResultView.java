package nextstep.ladder.view;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void printResult(List<String> names, String ladder) {
        System.out.println("\n실행결과");
        printNames(names);
        System.out.println(ladder);
    }

    private static void printNames(List<String> names) {
        for (int cnt = 0; cnt < names.size(); cnt++) {
            System.out.printf("%-6s", names.get(cnt));
        }
        System.out.println();
    }
}
