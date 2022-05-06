package ladder.view;

import ladder.domain.Line;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void printNames(String[] names) {
        Arrays.stream(names)
                .forEach(name -> System.out.print(name + "\t"));
        System.out.println();
    }

    public static void printLadder(List<Line> ladder) {
        ladder.stream()
                .forEach(line -> printLine(line.getLine()));
    }

    private static void printLine(List<Boolean> line) {
        line.stream()
                .forEach(e -> {
                    if (e == true) {
                        System.out.print("│---");
                    } else {
                        System.out.print("│" + "\t");
                    }
                });
        System.out.println("│");
    }
}
