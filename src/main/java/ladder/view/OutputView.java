package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class OutputView {
    private static final int NAME_BOX_SIZE = 6;
    private static final String BUFFER = "   ";
    private static final String NO_BRIDGE = "     |";
    private static final String BRIDGE = "-----|";

    public static void printGeneratedLadderResult(Players players, Prizes prizes, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printPlayerNames(players);
        printLadder(players, ladder);
        printPrizeNames(prizes);
    }

    private static void printPlayerNames(Players players) {
        System.out.print(BUFFER);

        players.getPlayers()
                .forEach((player) -> System.out.print(centerAlign(player.getName())));

        System.out.println();
    }

    private static void printLadder(Players players, Ladder ladder) {
        ladder.getRows()
                .forEach(row -> printRowOfLadder(row, players.getPlayerCount()));
    }

    private static void printPrizeNames(Prizes prizes) {
        System.out.print(BUFFER);

        prizes.getPrizes()
                .forEach((player) -> System.out.print(centerAlign(player.getPrize())));

        System.out.println();
    }

    private static void printRowOfLadder(Row row, int playerCount) {
        System.out.println(generateRowString(row, playerCount));
    }

    private static String generateRowString(Row row, int playerCount) {
        StringBuilder rowString = new StringBuilder(NO_BRIDGE);

        for (int i = 0; i < playerCount - 1; i++) {
            rowString.append(row.isConnected(i) ? BRIDGE : NO_BRIDGE);
        }

        return rowString.toString();
    }

    private static String centerAlign(String name) {
        int namePaddingSize = NAME_BOX_SIZE - name.length();

        int frontPadding = namePaddingSize / 2;
        int rearPadding = namePaddingSize - frontPadding;

        return " ".repeat(frontPadding) + name + " ".repeat(rearPadding);
    }

    public static void printPlayerResult(LadderGameResult gameResult, String targetName) {
        System.out.println("\n실행 결과");

        if ("all".equals(targetName)) {
            printAllPlayersResult(gameResult);
            return;
        }

        Prize prize = gameResult.findPrizeByPlayerName(targetName);
        System.out.println(prize.getPrize());
    }

    private static void printAllPlayersResult(LadderGameResult gameResult) {
        Map<Player, Prize> gameResultMap = gameResult.getGameResult();
        gameResultMap.forEach(((player, prize) -> System.out.println(player.getName() + " : " + prize.getPrize())));
    }
}
