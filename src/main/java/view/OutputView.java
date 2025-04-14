package view;

import domain.Ladder;
import domain.LadderGameEngine;
import domain.Line;
import domain.PlayerName;

import java.util.List;

public class OutputView {
    private static final String OUTPUT_MESSAGE = "output: %d";

    public static void printAllResultsIntro() {
        System.out.println("실행 결과");
    }

    public static void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printSingleResult(String result) {
        System.out.println(result);
    }

    public static void printResult(String name, String result) {
        System.out.println(name + " : " + result);
    }

    public void printOutput(int output) {
        System.out.printf(OUTPUT_MESSAGE + System.lineSeparator(), output);
    }

    public static void printNames(List<PlayerName> names) {
        names.forEach(name -> System.out.printf("%-6s", name));
        System.out.println();
    }

    public static void printLine(Line line) {
        System.out.println(line.toPrintableString());
    }

    public static void printLine(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    public static void printResults(List<String> results) {
        results.forEach(r -> System.out.printf("%-6s", r));
        System.out.println();
    }


}
