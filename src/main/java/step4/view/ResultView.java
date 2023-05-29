package step4.view;

import step4.domain.Ladder;
import step4.domain.Line;

import java.util.List;
import java.util.Scanner;

public class ResultView {
    private static final int PRINT_MAX_LENGTH = 7;
    private static final String SPACE = " ";
    private static final String VERTICAL = "|";
    private static final String SIGN_OF_HORIZONTAL = "-";
    public static final String ALL = "all";
    private static final Scanner scanner = new Scanner(System.in);

    public static void printLadderGame(Names names, Ladder ladder, Results results) {
        System.out.println("\n사다리 결과\n");
        printInputs(names.getNames());
        printLines(ladder.getLines());
        printInputs(results.getResults());
    }

    private static <T> void printInputs(List<T> inputs) {
        StringBuilder inputsToPrint = new StringBuilder();
        inputs.forEach(input -> inputsToPrint.append(printEachInput(input.toString())));
        System.out.println(inputsToPrint);
    }

    private static String printEachInput(String each) {
        StringBuilder eachString = new StringBuilder(SPACE);
        eachString.append(each);
        while (eachString.length() < PRINT_MAX_LENGTH) {
            eachString.append(SPACE);
        }
        return eachString.toString();
    }

    private static void printLines(List<Line> lines) {
        lines.forEach(ResultView::printEachLine);
    }

    private static void printEachLine(Line line) {
        StringBuilder lineBuilder = initLineBuilder();
        line.getLine().forEach(point -> {
                    lineBuilder.append(VERTICAL);
                    lineBuilder.append(buildEachHorizontal(point));
                }
        );
        lineBuilder.append(VERTICAL);
        System.out.println(lineBuilder);
    }

    private static StringBuilder initLineBuilder() {
        StringBuilder eachLinePadding = new StringBuilder();
        while (eachLinePadding.length() < PRINT_MAX_LENGTH / 2) {
            eachLinePadding.append(SPACE);
        }
        return eachLinePadding;
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

    public static void printResult(LadderGameResultMap ladderGameResultMap) {
        System.out.println("\n결과를 보고 싶은 사람은?");
        String name = scanner.next();
        System.out.println("\n실행결과");

        if (ALL.equals(name)) {
            printAll(ladderGameResultMap);
            return;
        }

        System.out.println(ladderGameResultMap.getResultByName(name));
        printResult(ladderGameResultMap);
    }

    private static void printAll(LadderGameResultMap ladderGameResultMap) {
        ladderGameResultMap.getResultMap()
                .forEach((name, result) -> System.out.println(name + " : " + result));
    }
}
