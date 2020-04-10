package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;
import ladder.domain.User;
import ladder.domain.type.DirectionType;

import java.util.List;

public class OutputView {
    private static final String ALL_RESULT = "all";

    private static final String HEIGHT = "|";
    private static final String WIDTH_POINT = "-----";
    private static final String WIDTH = "     ";
    private static final String RESULT = "사다리 결과";
    private static final String GAME_RESULT = "실행 결과";

    public static void resultPrint(LadderGame ladderGame) {
        System.out.println(RESULT);

        ladderGame.getUsers()
                .getUsers()
                .forEach(user -> System.out.printf("%-7s", user.getName()));

        printLadder(ladderGame);

        System.out.printf("\n");

        ladderGame.getLadder()
                .getLadderReward()
                .getRewards()
                .forEach(result -> System.out.printf("%-7s", result));

        System.out.printf("\n");
    }

    public static void gameResultPrint(LadderGame ladderGame, String name) {
        System.out.println(GAME_RESULT);

        if (name.equals(ALL_RESULT)) {
            List<User> users = ladderGame.getUsers().getUsers();

            users.forEach(user -> System.out.println(user.getName() + " : " + user.getReward()));

            return;
        }

        User user = ladderGame.getUsers()
                .findUser(name);

        System.out.println(user.getName() + " : " + user.getReward());
    }

    private static void printPoint(DirectionType directionType) {
        if (directionType == DirectionType.RIGHT) {
            System.out.printf(WIDTH_POINT);

            return;
        }

        System.out.printf(WIDTH);
    }

    private static void printLadder(LadderGame ladderGame) {
        for (LadderLine ladderLine : ladderGame.getLadder().getLadderLines()) {
            System.out.printf("\n%4s", "");

            ladderLine.getPoints().forEach(point -> {
                System.out.printf(HEIGHT);
                printPoint(point.getDirectionType());
            });
        }
    }
}
