package ladder.util;

import ladder.domain.Ladder;

import java.util.List;

public class OutputPrinter {

    public static void printResult(List<String> names, Ladder ladder) {
        System.out.println("실행 결과");
        names.stream()
                .map(name -> name + "  ")
                .reduce((left, right) -> left + right)
                .ifPresent(reduce -> {
                    System.out.println(reduce);
                    System.out.println(ladder);
                });
    }

    private OutputPrinter() {
    }
}
