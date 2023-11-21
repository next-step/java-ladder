package ladder.view;

import ladder.domain.*;

public class ResultView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String NAME_INTERVAL = "  ";
    private static final String ROW_INTERVAL = "  ";
    private static final String RESULT_INTERVAL = "    ";
    private static final String ROW_SEPERATOR = "|";
    private static final String FULL_COL = "-----";
    private static final String EMPTY_COL = "     ";

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
        ladder.rows().stream().forEach(row -> printRow(row));
    }

    private void printRow(Row row) {
        System.out.println(ROW_INTERVAL + rowText(row) + ROW_SEPERATOR);
    }

    private String rowText(Row row) {
        StringBuilder stringBuilder = new StringBuilder();
        row.cols().stream()
            .forEach(col -> {
                stringBuilder.append(ROW_SEPERATOR);
                stringBuilder.append(colText(col));
            });

        return stringBuilder.toString();
    }

    private String colText(Boolean col) {
        if (col) {
            return FULL_COL;
        }
        return EMPTY_COL;
    }

    public void printResults(Results results) {
        results.results().stream().forEach(result -> printResult(result));
        System.out.println();
    }

    private void printResult(Result result) {
        System.out.print(result.result() + RESULT_INTERVAL);
    }

}
