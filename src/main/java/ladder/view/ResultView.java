package ladder.view;

import ladder.domain.*;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_INTERVAL = "  ";
    private static final String LINE_INTERVAL = "  ";
    private static final String RESULT_INTERVAL = "    ";
    private static final String LINE_SEPERATOR = "|";
    private static final String FULL_POINT = "-----";
    private static final String EMPTY_POINT = "     ";

    public void printResult(Names names, Ladder ladder, Results results) {
        printResultMessage();
        printNames(names);
        printLadder(ladder);
        printResults(results);
    }

    private void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    private void printNames(Names names) {
        System.out.println();
        names.names().stream().forEach(name -> printName(name));
    }

    private void printName(Name name) {
        System.out.print(nameWithIntervalText(name));
    }

    private String nameWithIntervalText(Name name) {
        return name.name().concat(NAME_INTERVAL);
    }

    private void printLadder(Ladder ladder) {
        System.out.println();
        ladder.lines().stream().forEach(line -> printLine(line));
    }

    private void printLine(Line line) {
        System.out.println(LINE_INTERVAL + lineText(line) + LINE_SEPERATOR);
    }

    private String lineText(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        line.points().stream()
            .forEach(point -> {
                stringBuilder.append(LINE_SEPERATOR);
                stringBuilder.append(pointText(point));
            });

        return stringBuilder.toString();
    }

    private String pointText(Boolean point) {
        if (point) {
            return FULL_POINT;
        }
        return EMPTY_POINT;
    }

    public void printResults(Results results) {
        results.results().stream().forEach(result -> printResult(result));
        System.out.println();
    }

    private void printResult(Result result) {
        System.out.print(result.result() + RESULT_INTERVAL);
    }

}
