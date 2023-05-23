package step2.view;

import step2.domain.LadderGame;
import step2.domain.Line;
import step2.domain.Name;

import java.util.List;

public class ResultView {
    private static final int PRINT_NAME_LENGTH = 7;
    private static final String SPACE = " ";
    private static final String VERTICAL = "|";
    private static final String SIGN_OF_HORIZONTAL = "-";

    public static void printResult(LadderGame ladderGame) {
        System.out.println();
        System.out.println("실행 결과");
        System.out.println();

        printNames(ladderGame.getNames());
        printLines(ladderGame.getLines());
    }

    private static void printLines(List<Line> lines) {
        for (Line line : lines) {
            printEachLine(line);
        }
    }

    private static void printNames(List<Name> names) {
        StringBuilder namesToPrint = new StringBuilder();
        names.forEach(name -> namesToPrint.append(buildEachNameForPrint(name)));
        System.out.println(namesToPrint);
    }

    private static String buildEachNameForPrint(Name name) {
        StringBuilder eachName = new StringBuilder(SPACE);
        eachName.append(name);
        while (eachName.length() < PRINT_NAME_LENGTH) {
            eachName.append(SPACE);
        }
        return eachName.toString();
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
        while (eachLinePadding.length() < PRINT_NAME_LENGTH / 2) {
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
        while (horizontalBuilder.length() < PRINT_NAME_LENGTH - 1) {
            horizontalBuilder.append(sign);
        }
        return horizontalBuilder.toString();
    }
}
