package ladder;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printLadder(List<String> names, int ladderHeight, Ladder aladder, List<String> resultList) {
        List<Line> ladder = aladder.getLadder();

        System.out.println("\n실행결과\n");
        for (String name : names) {
            System.out.printf("%7s", name);
        }
        System.out.println();
        for (int i = 0; i < ladderHeight; i++) {
            Line line = ladder.get(i);
            System.out.printf("%7s", "|");
            for (int j = 1; j < names.size(); j++) {
                if (line.isConnected(j - 1, j)) {
                    System.out.printf("%s%s", "------", "|");
                } else {
                    System.out.printf("%7s", "|");
                }
            }
            System.out.println();
        }
        for (String result : resultList) {
            System.out.printf("%7s", result);
        }
        System.out.println();
    }

    public static void printResultOne(Result result) {
        System.out.println(result.getResult());
    }

    public static void pringResultAll(Map<Person, Result> results) {
        results.forEach((key, value) -> System.out.printf("%s : %s\n", key.getName(), value.getResult()));
    }
}
