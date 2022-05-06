package ladder.view;

import ladder.domain.Line;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final int STANDARD_SPACE_WHEN_PRINT_NAME = 3;

    private ResultView() {
    }

    public static void printNames(String[] names) {
        Arrays.stream(names)
                .forEach(name -> printName(name));
        System.out.println();
    }

    private static void printName(String name) {
        if (name.length() > STANDARD_SPACE_WHEN_PRINT_NAME) {
            System.out.print(name + "\t");
            return;
        }
        System.out.print(name + "\t\t");
    }

    public static void printLadder(List<Line> ladder) {
        ladder.stream()
                .forEach(line -> printLine(line.getLine()));
    }

    private static void printLine(List<Boolean> line) {
        line.stream()
                .forEach(e -> drawPartOfLine(e));
        System.out.println("│");
    }

    private static void drawPartOfLine(Boolean aBoolean) {
        if (aBoolean == true) {
            System.out.print("│-------");
            return;
        }
        System.out.print("│" + "\t\t");
    }
}
