package nextstep.ladder.presentation;

import java.util.List;
import nextstep.ladder.domain.LadderBarStatus;
import nextstep.ladder.domain.LadderPoints;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.dto.Rewards;

public class ResultView {

    private static final String LADDER_BAR = "-";
    private static final String LADDER_BOUNDARY = "|";
    private static final String SPACE = " ";
    private static final int BAR_LENGTH = 5;

    public static void printResult(Players players, LadderPoints ladderPoints, Rewards rewards) {
        List<Player> playerList = players.asList();

        StringBuilder stringBuilder = new StringBuilder("실행결과\n");
        for (Player player : playerList) {
            stringBuilder.append(playerNamePrintForm(player.getPlayerName().getName()));
        }
        stringBuilder.append("\n");

        for (int row = 0; row < ladderPoints.getLadderLength(); row++) {
            stringBuilder
                .append(SPACE.repeat(BAR_LENGTH))
                .append(LADDER_BOUNDARY);

            for (int column = 0; column < players.size() - 1; column++) {
                LadderBarStatus ladderBarStatus = ladderPoints.get(row, column)
                    .getLadderBarStatus();

                stringBuilder.append(
                        ladderBarStatus.isEmpty() ? SPACE.repeat(BAR_LENGTH)
                            : LADDER_BAR.repeat(BAR_LENGTH))
                    .append(LADDER_BOUNDARY);
            }

            stringBuilder.append("\n");
        }

        for (String reward : rewards.getRewards()) {
            stringBuilder.append(playerNamePrintForm(reward));
        }

        System.out.println(stringBuilder);
    }

    public static void printAllPlayersResult(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("실행 결과\n");

        for (Player player : players.asList()) {
            stringBuilder.append(player.getPlayerName().getName())
                .append(" : ")
                .append(player.getResult())
                .append("\n");
        }

        System.out.println(stringBuilder);
    }

    public static void printAPlayerResult(String result) {
        System.out.println(result);
    }


    private static String playerNamePrintForm(String name) {
        int spaceCount = BAR_LENGTH - name.length() + 1;

        return SPACE.repeat(spaceCount) + name;
    }
}
