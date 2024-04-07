package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.vo.Rows;

public class OutputView {

    private static final int PLAYER_NAME_COLUMN_WIDTH = 5;

    public static void printLadderResult(Ladder ladder, Players players){
        System.out.println("실행결과");
        printPlayers(players);

        ladder.rowsList()
                .forEach(OutputView::printRows);
    }

    private static void printPlayers(Players players){
        players.players()
                .forEach(player ->
                    System.out.print(formatPlayerName(player.name()))
                );
        System.out.println();
    }

    private static String formatPlayerName(String name) {
        int spacesLeft = (PLAYER_NAME_COLUMN_WIDTH - name.length()) / 2;
        int spacesRight = PLAYER_NAME_COLUMN_WIDTH - name.length() - spacesLeft;

        StringBuilder formattedName = new StringBuilder();
        formattedName.append(" ".repeat(Math.max(spacesLeft, 0)));
        formattedName.append(name);
        formattedName.append(" ".repeat(Math.max(spacesRight, 0)));

        return formattedName.toString();
    }

    private static void printRows(Rows rows){
        System.out.print("  |");
        rows.rows().forEach(row -> {
            if (row.bridgeExist()) {
                System.out.print("----|");
                return;
            }
            System.out.print("    |");
        });
        System.out.println();
    }
}
