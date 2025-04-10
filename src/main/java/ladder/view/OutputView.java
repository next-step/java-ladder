package ladder.view;

import ladder.domain.*;

import java.util.List;

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
                .forEach(row -> printRowOfLadder(row, players.count()));
    }

    private static void printPrizeNames(Prizes prizes) {
        System.out.print(BUFFER);

        prizes.getPrizes()
                .forEach((player) -> System.out.print(centerAlign(player.getValue())));

        System.out.println();
    }

    private static void printRowOfLadder(Row row, int playerCount) {
        System.out.println(generateRowString(row, playerCount));
    }

    private static String generateRowString(Row row, int playerCount) {
        StringBuilder rowString = new StringBuilder(NO_BRIDGE);

        int numberOfBridges = playerCount - 1;
        for (int i = 0; i < numberOfBridges; i++) {
            rowString.append(row.isConnectedToRight(i) ? BRIDGE : NO_BRIDGE);
        }

        return rowString.toString();
    }

    public static void printPlayerResult(LadderGameResults gameResults, String targetName) {
        System.out.println("\n실행 결과");

        if ("all".equals(targetName)) {
            printAllPlayersResult(gameResults);
            return;
        }

        Prize prize = gameResults.findPrizeByPlayerName(targetName);
        System.out.println(prize.getValue());
    }

    private static void printAllPlayersResult(LadderGameResults gameResults) {
        List<LadderGameResult> ladderGameResults = gameResults.getLadderGameResults();
        ladderGameResults.forEach(result -> System.out.println(result.getPlayerName() + " : " + result.getPrizeValue()));
    }

    private static String centerAlign(String name) {
        int namePaddingSize = NAME_BOX_SIZE - name.length();

        int frontPadding = namePaddingSize / 2;
        int rearPadding = namePaddingSize - frontPadding;

        return " ".repeat(frontPadding) + name + " ".repeat(rearPadding);
    }
}
