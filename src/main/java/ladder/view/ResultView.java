package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    public static final String LINE = "-----";
    public static final String LINE_BLANK = "     ";
    public static final String LADDER_COLUMN = "|";
    public static final String CHANGE_LINE = "\n";

    public void printLadder(Names names, Ladder ladder, LadderResult ladderResult) {
        StringBuilder sb = new StringBuilder();
        names.stream()
                .forEach(name -> sb.append(String.format("%6s", name.value())));
        sb.append(CHANGE_LINE);
        ladder.stream()
                .forEach(line -> sb.append(formatLine(line)));
        ladderResult.stream()
                .forEach(result -> sb.append(String.format("%6s", result)));
        sb.append(CHANGE_LINE+CHANGE_LINE);
        System.out.println(sb.toString());
    }

    private String formatLine(Line line) {
        String lines = line.points().stream()
                .map(point -> draw(point))
                .collect(Collectors.joining(LADDER_COLUMN));
        return LINE_BLANK + LADDER_COLUMN + lines + LADDER_COLUMN + CHANGE_LINE;
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
                .forEach(index -> System.out.println(names.get(index).value() + " : " + results.get(index)));
    }
}
