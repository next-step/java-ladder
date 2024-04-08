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

    private static StringBuilder formatPlayerName(String name) {
        int spacesLeft = (PLAYER_NAME_COLUMN_WIDTH - name.length()) / 2;
        int spacesRight = PLAYER_NAME_COLUMN_WIDTH - name.length() - spacesLeft;

        StringBuilder formattedName = new StringBuilder();
        formattedName.append(" ".repeat(Math.max(spacesLeft, 0)));
        formattedName.append(name);
        formattedName.append(" ".repeat(Math.max(spacesRight, 0)));

        return formattedName;
    }

    private static void printRows(Rows rows) {
        StringBuilder rowsString = new StringBuilder("  |");
        rows.rows().forEach(row -> {
            if (row.bridgeExist()) {
                rowsString.append("----|");
                return;
            }
            rowsString.append("    |");
        });

        System.out.println(rowsString);
    }
}
