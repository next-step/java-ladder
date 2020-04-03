package ladder.view;

import ladder.model.Player;
import ladder.model.Row;
import ladder.model.Rows;

import java.util.List;

public class ResultView {
    public static void printPlayers(List<Player> players) {
        players.stream()
                .map(Player::getName)
                .map(it -> it + createBlanks(findNeededBlankCount(it)))
                .forEach(it -> System.out.print(it));
        System.out.println();
    }

    public static void printRows(Rows rows, List<Player> players) {
        for (int i = 0; i < rows.getSize(); i++) {
            printOneRow(rows.getRowsElement(i), players);
        }
    }

    private static int findNeededBlankCount(String name) {
        return 6 - name.length();
    }

    private static StringBuilder createBlanks(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    private static void printOneRow(Row row, List<Player> players) {
        System.out.print("|");
        for (int i = 1; i < players.size(); i++) {
            printValue(row.getRowElement(i));
            System.out.print("|");
        }
        System.out.println();
    }

    private static void printValue(boolean booleanValue) {
        String input = booleanValue ? "-----" : "     ";
        System.out.print(input);
    }
}