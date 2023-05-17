package ladder.util;

import ladder.domain.Ladder;

import java.util.List;

public class OutputPrinter {

    public static void printDisplay(List<String> names, Ladder ladder, List<String> matchingResult) {
        System.out.println("실행 결과");
        names.stream()
                .map(name -> name + "  ")
                .reduce((left, right) -> left + right)
                .ifPresent(reduce -> {
                    System.out.println(reduce);
                    System.out.println(ladder.print());
                });

        matchingResult.stream()
                .map(name -> name + "  ")
                .reduce((left, right) -> left + right)
                .ifPresent(reduce -> {
                    System.out.println(reduce);
                });
    }

    public static void printMatchingResult(List<String> participantNames,
                                           Ladder ladder,
                                           List<String> results) {
        participantNames.stream()
                .forEach(item -> {
                    System.out.print(item + " : ");
                    System.out.println(results.get(ladder.getResultPosition(item)));
                });
    }

    private OutputPrinter() {
    }
}
