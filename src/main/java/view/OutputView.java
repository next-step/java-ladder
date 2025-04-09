package view;

import domain.Ladder;
import domain.Line;
import domain.PlayerName;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

//    public static void printLine(Ladder ladder) {
//        ladder.printline();
//    }

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + System.lineSeparator(), output);
    }

    public static void printNames(List<PlayerName> names) {
        names.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

    public static void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        for (boolean point : line.getPoints()) {
            builder.append("|");
            builder.append(point ? "-----" : "     ");
        }
        builder.append("|");
        System.out.println(builder);
    }

    public static void printLine(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

}
