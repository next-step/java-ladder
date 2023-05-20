package ladder.util;

import ladder.domain.Ladder;

import java.util.List;
import java.util.function.Consumer;

public class OutputPrinter {

    public static void printDisplay(List<String> names, Ladder ladder, List<String> matchingResult) {
        System.out.println("실행 결과");

        printReducedResult(names, result -> {
            System.out.println(result);
            System.out.println(ladder.print());
        });

        printReducedResult(matchingResult, result -> System.out.println(result));
    }

    public static <T> void printReducedResult(List<T> strings, Consumer<String> ifPresentConsumer) {
        strings.stream()
                .map(name -> name + "  ")
                .reduce((left, right) -> left + right)
                .ifPresent(ifPresentConsumer);
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
