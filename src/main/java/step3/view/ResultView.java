package step3.view;

import step3.domain.*;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    private static final int PRINT_MAX_LENGTH = 7;
    private static final String SPACE = " ";
    private static final String VERTICAL = "|";
    private static final String SIGN_OF_HORIZONTAL = "-";
    public static final String ALL = "all";
    private static final Scanner scanner = new Scanner(System.in);

    public static void printLadderGame(LadderGame ladderGame, Results results) {
        System.out.println("\n사다리 결과\n");
        printInputs(ladderGame.getNames());
        printLines(ladderGame.getLines());
        printInputs(results.getResults());
    }

    private static <T> void printInputs(List<T> inputs) {
        StringBuilder inputsToPrint = new StringBuilder();
        inputs.forEach(input -> inputsToPrint.append(buildEachForPrint(input.toString())));
        System.out.println(inputsToPrint);
    }

    private static String buildEachForPrint(String each) {
        StringBuilder eachName = new StringBuilder(SPACE);
        eachName.append(each);
        while (eachName.length() < PRINT_MAX_LENGTH) {
            eachName.append(SPACE);
        }
        return eachName.toString();
    }

    private static void printLines(List<Line> lines) {
        for (Line line : lines) {
            printEachLine(line);
        }
    }

    private static void printEachLine(Line line) {
        StringBuilder lineBuilder = new StringBuilder();
        lineBuilder.append(initLineBuilder());
        line.getPoints().forEach(point -> {
                    lineBuilder.append(buildEachHorizontal(point));
                    lineBuilder.append(VERTICAL);
                }
        );
        System.out.println(lineBuilder);
    }

    private static String initLineBuilder() {
        StringBuilder eachLinePadding = new StringBuilder();
        while (eachLinePadding.length() < PRINT_MAX_LENGTH / 2) {
            eachLinePadding.append(SPACE);
        }
        eachLinePadding.append(VERTICAL);
        return eachLinePadding.toString();
    }

    private static String buildEachHorizontal(Boolean point) {
        if (point) {
            return buildHorizontal(SIGN_OF_HORIZONTAL);
        }
        return buildHorizontal(SPACE);
    }

    private static String buildHorizontal(String sign) {
        StringBuilder horizontalBuilder = new StringBuilder();
        while (horizontalBuilder.length() < PRINT_MAX_LENGTH - 1) {
            horizontalBuilder.append(sign);
        }
        return horizontalBuilder.toString();
    }

    public static void printResult(LadderGame ladderGame, Results results) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String name = scanner.next();
        System.out.println("\n실행결과");

        if (ALL.equals(name)) {
            printAll(ladderGame, results);
            return;
        }

        System.out.println(ladderGame.getEachResult(new Name(name), results));
        printResult(ladderGame, results);
    }

    private static void printAll(LadderGame ladderGame, Results results) {
        ladderGame.getNames().forEach(name -> {
            System.out.println(name + " : " + ladderGame.getEachResult(name, results));
        });
    }
}
