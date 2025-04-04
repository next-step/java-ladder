package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Row;

public class OutputView {
    private static final int NAME_BOX_SIZE = 6;
    private static final String EMPTY = "     |";
    private static final String BRIDGE = "-----|";

    public static void printGeneratedLadderResult(Players players, Ladder ladder) {
        System.out.println("\n실행결과\n");
        printPlayerNames(players);
        printLadder(players, ladder);
    }

    private static void printPlayerNames(Players players) {
        System.out.print("   ");

        players.getPlayers()
                .forEach((player) -> System.out.print(centerAlign(player.getName())));

        System.out.println();
    }

    private static void printLadder(Players players, Ladder ladder) {
        ladder.getRows()
                .forEach(row -> printRowOfLadder(row, players.getPlayerCount()));
    }

    private static void printRowOfLadder(Row row, int playerCount) {
        System.out.println(generateRowString(row, playerCount));
    }

    private static String generateRowString(Row row, int playerCount) {
        StringBuilder rowString = new StringBuilder(EMPTY);

        for (int i = 0; i < playerCount - 1; i++) {
            rowString.append(row.shouldBuildBridge(i) ? BRIDGE : EMPTY);
        }

        return rowString.toString();
    }

    private static String centerAlign(String name) {
        int namePaddingSize = NAME_BOX_SIZE - name.length();

        int frontPadding = namePaddingSize / 2;
        int rearPadding = namePaddingSize - frontPadding;

        return " ".repeat(frontPadding) + name + " ".repeat(rearPadding);
    }
}
