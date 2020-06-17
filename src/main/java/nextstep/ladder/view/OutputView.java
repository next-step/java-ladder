package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.game.LadderGamePrize;
import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStore;

import java.util.List;

public class OutputView {
    private static final String VERTICAL_LADDER_LINE = "|";
    private static final String LADDER_CONNECTION_LINE = "-----";
    private static final String BLANK_INTERVAL = "     ";

    private static final String ALL_USER = "all";
    private static final String LADDER_OUTPUT_START_MESSAGE = "실행결과";

    private OutputView() {
    }

    public static void drawLadder(Ladder ladder, LadderGamePrize prizes) {
        ladder.getLadderGameUsers().getLadderGameUserNames()
                .forEach(userName -> System.out.printf("%s%s", userName, BLANK_INTERVAL));
        System.out.println();

        for (int point = 1, height = ladder.getMaxPoint().getPosition(); point <= height; point++) {
            System.out.println(BLANK_INTERVAL + drawLadderLine(ladder, point));
        }
        prizes.findAllPrizes()
                .forEach(prize -> System.out.printf("%s%s", prize, BLANK_INTERVAL));
        System.out.println();
    }

    private static String drawLadderLine(final Ladder ladder, final int point) {
        StringBuilder ladderLine = new StringBuilder();
        for (int order = 1, count = ladder.getNumberOfUsers(); order < count; order++) {
            ladderLine.append(VERTICAL_LADDER_LINE);
            ladderLine.append(drawConnectionLine(ladder, point, order));
        }
        ladderLine.append(VERTICAL_LADDER_LINE);
        return ladderLine.toString();
    }

    private static String drawConnectionLine(final Ladder ladder, final int point, final int order) {
        StringBuilder connectionLine = new StringBuilder();
        if (isConnected(ladder, point, order)) {
            connectionLine.append(LADDER_CONNECTION_LINE);
        } else {
            connectionLine.append(BLANK_INTERVAL);
        }
        return connectionLine.toString();
    }

    private static boolean isConnected(final Ladder ladder, final int point, final int order) {
        return ladder.hasConnection(order, point);
    }

    public static void printPrize(final LadderGameUserStore userStore, final String resultUser, final LadderGameResult ladderGameResult) {
        System.out.println(LADDER_OUTPUT_START_MESSAGE);
        if (ALL_USER.equals(resultUser)) {
            printAllResult(userStore, ladderGameResult);
            return;
        }
        userStore.findByUserName(resultUser)
                .ifPresent(user -> System.out.printf("%s : %s", user.getUserName(), ladderGameResult.getPrizeOf(user)));
    }

    private static void printAllResult(final LadderGameUserStore userStore, final LadderGameResult ladderGameResult) {
        List<LadderGameUser> allOfUsers = userStore.findAll();
        for (LadderGameUser user : allOfUsers) {
            System.out.printf("%s : %s%n", user.getUserName(), ladderGameResult.getPrizeOf(user));
        }
        return;
    }
}
