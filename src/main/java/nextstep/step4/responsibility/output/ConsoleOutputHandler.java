package nextstep.step4.responsibility.output;

import nextstep.step4.responsibility.domain.*;
import nextstep.step4.responsibility.input.ConsoleInputHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleOutputHandler implements OutputHandler {
    private final Ladder ladder;

    public ConsoleOutputHandler(final Ladder ladder) {
        this.ladder = ladder;
    }

    @Override
    public void outputMakingLadderResult() {
        printLadderUserInput(this.ladder.userNames());
        printLadderBody(this.ladder.indexHorizontalMovers());
        printLadderUserInput(this.ladder.userResults());
    }

    private void printLadderUserInput(final UserInputProvider userInputTexts) {
        final List<String> texts = userInputTexts.getList();

        final String printUserNames = texts.stream()
                .map(str -> String.format("%5s", str))
                .collect(Collectors.joining(" "));

        System.out.println(printUserNames);
    }

    private void printLadderBody(final List<Row> rows) {
        for (final Row rowMover : rows) {
            final String rowMoversString = printLadderRowMovers(rowMover);

            System.out.println(rowMoversString);
        }
    }

    private String printLadderRowMovers(final Row row) {
        StringBuilder sb = new StringBuilder();
        final String delimiter = "|";
        final String prefix = " ".repeat(UserNames.MAX_NAME_LENGTH - 1) + delimiter;

        sb.append(prefix);

        for (int idx = 0; idx < row.size() - 1; idx++) {
            sb.append(convertToLadderLineString(row.get(idx)));
            sb.append(delimiter);
        }

        return sb.toString();
    }

    private String convertToLadderLineString(final IndexHorizontalMover rowMover) {
        if (rowMover == Mover.RIGHT) {
            return "-".repeat(UserNames.MAX_NAME_LENGTH);
        }

        return " ".repeat(UserNames.MAX_NAME_LENGTH);
    }

    @Override
    public void outputGameResult(GameResultProvider gameResult) {
        ConsoleInputHandler inputHandler = new ConsoleInputHandler();
        boolean stopFlag = false;

        while (!stopFlag) {
            final String userName = inputHandler.inputGamePlayerName();

            final String runResult = getConsoleResult(gameResult, userName);
            System.out.println("\n실행 결과\n" + runResult);

            stopFlag = checkStopFlag(userName);
        }
    }

    private String getConsoleResult(final GameResultProvider gameResult, final String userName) {
        if ("all".equals(userName)) {
            return buildAllResult(gameResult.getAllResult());
        }

        String result = gameResult.getResult(userName);
        if (result == null) {
            result = "존재하지 않는 사용자입니다.";
        }

        return result;
    }

    private String buildAllResult(final Map<String, String> result) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : result.entrySet()) {
            sb.append(String.format("%s : %s", entry.getKey(), entry.getValue()));
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    private boolean checkStopFlag(final String userName) {
        return "all".equals(userName);
    }
}
