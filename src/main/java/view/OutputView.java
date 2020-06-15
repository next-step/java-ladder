package view;

import domain.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static final String LINE = "|";
    public static final String CONNECT = "-----";
    public static final String NOT_CONNECT = "     ";

    public static void printResult(Ladder ladder) {
        System.out.println("실행결과");

        System.out.println(ladder.getPlayerNames());

        System.out.println(ladder.getLines().stream()
                .map(line -> getLineText(line.getPoints()))
                .collect(Collectors.joining("\n")));
    }

    public static String getLineText(List<Boolean> points) {
        return LINE.concat(points.stream()
                .map(point -> point ? CONNECT : NOT_CONNECT)
                .collect(Collectors.joining(LINE)))
                .concat(LINE);
    }
}
