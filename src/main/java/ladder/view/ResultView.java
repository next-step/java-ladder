package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static final String LINE = "-----";
    public static final String LINE_BLANK = "     ";
    public static final String LADDER_COLUMN = "|";

    public void printLadder(Names names, Ladder ladder, LadderResult ladderResult) {
        names.names().stream()
                .forEach(name -> System.out.printf("%6s", name.name()));
        System.out.println();
        ladder.lines().stream()
                .forEach(line -> printLine(line));
        ladderResult.result().stream()
                .forEach(result -> System.out.printf("%6s", result));
        System.out.println();
        System.out.println();
    }

    private void printLine(Line line) {
        String lines = line.points().stream()
                .map(point -> draw(point))
                .collect(Collectors.joining(LADDER_COLUMN));
        String lineString = LINE_BLANK + LADDER_COLUMN + lines + LADDER_COLUMN;
        System.out.println(lineString);
    }

    private String draw(boolean point) {
        if (point) {
            return LINE;
        }
        return LINE_BLANK;
    }

    public void printResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
    }

    public void printResult(Names names, List<String> results) {
        System.out.println("실행 결과");
        IntStream.range(0, results.size())
                .forEach(index -> System.out.println(names.get(index).name() + " : " + results.get(index)));
    }
}
