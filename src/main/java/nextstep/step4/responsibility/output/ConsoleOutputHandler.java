package nextstep.step4.responsibility.output;

import nextstep.step4.responsibility.domain.*;
import nextstep.step4.responsibility.input.ConsoleInputHandler;

import java.util.List;
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

    private void printLadderBody(final IndexHorizontalMover[][] movers) {
        for (final IndexHorizontalMover[] rowMover : movers) {
            final String rowMoversString = printLadderRowMovers(rowMover);

            System.out.println(rowMoversString);
        }
    }

    private String printLadderRowMovers(final IndexHorizontalMover[] rowMover) {
        StringBuilder sb = new StringBuilder();
        final String delimiter = "|";
        final String prefix = " ".repeat(UserNames.MAX_NAME_LENGTH - 1) + delimiter;

        sb.append(prefix);

        for (int idx = 0; idx < rowMover.length - 1; idx++) {
            sb.append(convertToLadderLineString(rowMover[idx]));
            sb.append(delimiter);
        }

        return sb.toString();
    }

    private String convertToLadderLineString(final IndexHorizontalMover rowMover) {
        if (rowMover instanceof RightMover) {
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

            final String runResult = gameResult.getResult(userName);
            System.out.println("\n실행 결과\n" + runResult);

            stopFlag = checkStopFlag(userName);
        }
    }

    private boolean checkStopFlag(final String userName) {
        return "all".equals(userName);
    }
}
