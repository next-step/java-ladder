package view;

import domain.Line;

import java.util.List;

public class OutputView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String VERTICAL_LINE = "|";

    public static void printResultTitle() {
        System.out.println(System.lineSeparator() + "실행결과");
    }

    public static void printParticipants(List<String> names) {
        for (String name : names) {
            System.out.printf("%-6s", name);
        }
        System.out.println();
    }

    public static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            printLine(line.getPoints());
        }
    }

    private static void printLine(List<Boolean> points) {
        StringBuilder sb = new StringBuilder();
        sb.append(EMPTY_LINE);

        for (boolean point : points) {
            sb.append(VERTICAL_LINE);
            sb.append(point ? HORIZONTAL_LINE : EMPTY_LINE);
        }
        sb.append(VERTICAL_LINE);
        System.out.println(sb);
    }
}