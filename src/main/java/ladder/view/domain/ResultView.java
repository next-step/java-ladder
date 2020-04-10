package ladder.view.domain;

import ladder.domain.PlayerName;
import ladder.domain.Result;

public class ResultView implements DomainPrintable<Result> {
    private static final String RESULT_JOINER = " : ";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final int EXIT = 0;

    private final Result result;

    public ResultView(final Result result) {
        this.result = result;
    }

    public void printResult(PlayerName playerName) {
        newLine();
        printResultMessage();
        if (playerName.isAll()) {
            print(result);
            System.exit(EXIT);
        }
        printSingleResult(playerName);
        newLine();
    }

    @Override
    public void print(final Result result) {
        result.getResult()
              .keySet()
              .forEach(player -> System.out.println(player.name().value() + RESULT_JOINER + result.get(player).getPrize()));
    }

    private void printSingleResult(PlayerName playerName) {
        System.out.println(result.findOne(playerName));
    }

    private static void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    private static void newLine() {
        System.out.println();
    }
}
