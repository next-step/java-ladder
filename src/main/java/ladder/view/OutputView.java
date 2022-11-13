package ladder.view;

import ladder.model.*;

import java.util.List;

public class OutputView {

    private static final String ALL_PLAYER = "all";
    private static final String BAR = "|";
    private static final String COLON = " : ";
    private static final String LADDER_LINE = "------";

    private OutputView() {
        throw new AssertionError();
    }

    public static void show(String message) {
        System.out.println(message);
    }

    public static void nextLine() {
        System.out.println();
    }

    private static void nextTab(String message) {
        System.out.printf("%7s", message);
    }

    public static void showResultMessage() {
        show("실행결과");
    }

    public static void showPlayersName(Players players) {
        players.getPlayers()
                .forEach(player -> nextTab(player.getName()));

        nextLine();
    }

    public static void showLadder(LadderGame ladderGame) {
        ladderGame.getLadder().getLadderLine().stream().forEach(ladderLine -> {
            showLadderLine(ladderLine);
            nextLine();
        });
    }

    public static void showReward(LadderRewards ladderRewards) {
        ladderRewards.getRewards()
                .forEach(reward -> nextTab(reward.getResult()));

        nextLine();
    }

    public static void showResultByPlayer(Reward reward, Player player) {
        show(player.getName() + COLON + reward.getResult());
    }

    public static void showResultAll(LadderRewards ladderRewards, Players players) {
        List<Player> playerInfos = players.getPlayers();

        for (int i = 0; i < playerInfos.size(); i++) {
            show(playerInfos.get(i).getName() + COLON + ladderRewards.get(i).getResult());
        }
    }

    private static void showLadderLine(LadderLine ladderLine) {
        nextTab(BAR);

        List<Point> points = ladderLine.getPoints();

        for (int i = 0; i < ladderLine.getPoints().size() - 1; i++) {
            if (points.get(i).getDirection().isConnectedRight()) {
                showLadderLine();
            } else {
                nextTab(BAR);
            }
        }
    }

    private static void showLadderLine() {
        System.out.printf("%s%s", LADDER_LINE, BAR);
    }
}
