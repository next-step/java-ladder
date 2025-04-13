package view;

import domain.Line;
import domain.Participant;
import domain.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String VERTICAL_LINE = "|";

    public static void printResultTitle() {
        System.out.println(System.lineSeparator() + "실행결과");
    }

    public static void printParticipants(Participants participants) {
        List<String> names = participants.getValues().stream()
                .map(Participant::getName).collect(Collectors.toList());
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