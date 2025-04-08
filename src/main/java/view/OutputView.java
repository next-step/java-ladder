package view;

import domain.Ladder;
import domain.Line;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

    public static void printLine(Ladder ladder) {
        ladder.printline();
    }

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + System.lineSeparator(), output);
    }

    public static void printNames(List<String> names) {
        names.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

}
