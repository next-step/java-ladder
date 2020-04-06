package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.User;
import ladder.domain.type.ActionType;

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

        ladderGame.getUsers().forEach(user -> System.out.printf("%-7s", user.getName()));

        printLadder(ladderGame);

        System.out.printf("\n");

        ladderGame.getLadder()
                .getRewards()
                .forEach(result -> System.out.printf("%-7s", result));

        System.out.printf("\n");
    }

    public static void gameResultPrint(LadderGame ladderGame, String name) {
        System.out.println(GAME_RESULT);

        if (name.equals(ALL_RESULT)) {
            List<User> users = ladderGame.getUsers();
            users.forEach(user -> System.out.println(user.getName() + " : " + user.getReward()));

            return;
        }

        User user = ladderGame.findUser(name);
        System.out.println(user.getName() + " : " + user.getReward());
    }

    private static void printPoint(ActionType actionType) {
        if (actionType == ActionType.RIGHT) {
            System.out.printf(WIDTH_POINT);

            return;
        }

        System.out.printf(WIDTH);
    }

    private static void printLadder(LadderGame ladderGame) {
        for (Line line : ladderGame.getLadder().getLines()) {
            System.out.printf("\n%4s", "");

            line.getActions().forEach(point -> {
                System.out.printf(HEIGHT);
                printPoint(point);
            });
        }
    }
}
