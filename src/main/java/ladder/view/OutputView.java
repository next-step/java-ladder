package ladder.view;

import java.util.stream.Collectors;
import ladder.domain.Ladder;
import ladder.domain.LadderPrize;
import ladder.domain.LadderPrizes;
import ladder.domain.LadderResult;
import ladder.domain.Users;

public class OutputView {
    private static final String LADDER_RESULT_MESSAGE = "\n사다리 결과\n";
    private static final String LADDER_PRIZE = "\n실행 결과";
    private static final String LADDER_VERTICAL = "|";
    private static final String LADDER_HORIZON = "-----";
    private static final String LADDER_NONE = "     ";
    private static final String COLON = " : ";

    public static void printGeneratedLadder(Users users, Ladder ladder, LadderPrizes ladderResults) {
        System.out.println(LADDER_RESULT_MESSAGE);
        printUserNames(users);
        printLadder(ladder);
        printResults(ladderResults);
    }

    private static void printUserNames(Users users) {
        String name = users.getUsers().stream()
                .map(user -> String.format("%6s", user.getName()))
                .collect(Collectors.joining(""));
        System.out.println(name);
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(line -> {
            line.getPoints().forEach(OutputView::printLine);
            System.out.println();
        });
    }

    private static void printResults(LadderPrizes ladderPrizes) {
        String results = ladderPrizes.getPrizes().stream()
                .map(result -> String.format("%-6s", result.getResult()))
                .collect(Collectors.joining(""));
        System.out.println(results);
    }

    private static void printLine(boolean hasLine) {
        if (hasLine) {
            System.out.print(LADDER_HORIZON + LADDER_VERTICAL);
            return;
        }
        System.out.print(LADDER_NONE + LADDER_VERTICAL);
    }

    public static void printPersonalResult(LadderPrize ladderPrize) {
        System.out.println(LADDER_PRIZE);
        System.out.println(ladderPrize.getResult());
    }

    public static void printTotalPrize(LadderResult ladderResult) {
        System.out.println(LADDER_PRIZE);
        ladderResult.getLottoResult().forEach(
                ((userName, ladderPrize) -> System.out.println(userName.getName() + COLON + ladderPrize.getResult())));
    }
}
