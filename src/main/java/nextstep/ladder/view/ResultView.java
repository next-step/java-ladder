package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.List;

public class ResultView {

    private ResultView() {

    }

    public static void printResult(Ladder ladder, List<String> names) {
        System.out.println("\n실행결과");
        printNames(names);
        for (Line line : ladder.getLines()) {
            printLadderLine(line.getPoints());
        }
    }

    private static void printNames(List<String> names) {
        for (int cnt = 0; cnt < names.size(); cnt++) {
            System.out.printf("%-6s", names.get(cnt));
        }
        System.out.println();
    }

    public static void printLadderLine(List<Boolean> line) {
        int pos = 0;
        for (pos = 0; pos < line.size() - 1; pos++) {
            if (pos != 0 && line.get(pos - 1)) {
                System.out.print("     ");
            }
            System.out.print("|");
            if (line.get(pos) && line.get(pos + 1)) {
                System.out.print("-----|");
                pos++;
                continue;
            }
            System.out.print("     ");
        }
        if (line.get(line.size() - 2)) {
            System.out.print("     ");
        }
        if (!line.get(line.size() - 1)) {
            System.out.print("|");
        }
        System.out.println();
    }
}
