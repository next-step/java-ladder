package nextstep.ladder.view;

import nextstep.ladder.domain.Rung;
import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.LadderResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printLadderResultString() {
        System.out.println("\n사다리 결과\n");
    }

    public static void printResult(
            List<String> people,
            List<String> results,
            LadderResult ladderResult
    ) {
        while (true) {
            String wantedName = InputView.nextWantedName();
            if (wantedName.equals("all")) {
                people.forEach(person -> {
                    int index = people.indexOf(person);
                    Integer result = ladderResult.findResult(index);
                    System.out.println(person + " : " + results.get(result));
                });
                return;
            }
            int index = people.indexOf(wantedName);
            Integer result = ladderResult.findResult(index);
            System.out.println("\n실행 결과");
            System.out.println(results.get(result));
        }
    }

    public static void printSplitOf(List<String> strings) {
        for (String string : strings) {
            String gap = "     ".substring(0, 5 - string.length());
            System.out.print(string + gap);
        }
        System.out.println();
    }

    public static void printRenderLines(Ladder ladder) {
        String renderLines = ladder.getLines().stream()
                .map(line -> "     " + render(line.getRungs()) + "\n")
                .collect(Collectors.joining());
        System.out.println(renderLines);
    }

    private static String render(List<Rung> rungs) {
        return rungs.stream()
                .map(rung -> "|" + (rung.isRight() ? "-----" : "     "))
                .collect(Collectors.joining());
    }
}
