package nextstep.view;

import nextstep.domain.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PILLAR = "|";
    private static final String FOODHOLDER = "-";

    public static void outputUserNames(List<Username> usernames) {
        System.out.printf("%n사다리 결과%n%n");

        usernames.forEach(name -> System.out.print(
                " ".repeat(Username.LENGTH_MAX - name.length()) + name.getName() + " "));
    }

    public static void outputLadder(Lines lines) {
        lines.getLines().forEach(OutputView::outputLine);

        System.out.println();
    }

    private static void outputLine(Line line) {
        System.out.printf("%n" + " ".repeat(Username.LENGTH_MAX - 1) + PILLAR);

        for (boolean point : line.getPoints()) {
            if (point) {
                System.out.print(FOODHOLDER.repeat(Username.LENGTH_MAX) + PILLAR);
                continue;
            }
            System.out.print(" ".repeat(Username.LENGTH_MAX) + PILLAR);
        }
    }

    public static void outputLadderResult(List<String> LadderResult) {
        LadderResult.forEach(result -> System.out.print(
                " ".repeat(Math.max((Username.LENGTH_MAX - result.length()), 0)) + result + " "));
    }

    public static void outputExecutionResult(Map<Username, String> results) {
        System.out.printf("%n실행 결과%n");

        if (results.size() == 1) {
            results.values().forEach(System.out::println);
            return;
        }

        for (Username username : results.keySet()) {
            System.out.printf("%s : %s%n", username.getName(), results.get(username));
        }
    }
}
