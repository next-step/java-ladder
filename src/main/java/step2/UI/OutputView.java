package step2.UI;

import step2.Line;
import step2.Player;

import java.util.List;

public class OutputView {

    public static final String RESULT_MESSAGE ="실행결과";
    public static final String LADDER_HEIGHT_DRAWING = "|";
    public static final String BLANK = " ";
    public static final int MAX_NAME_LENGTH = 5;

    public static void outputView(List<Line> lines, List<Player> players) {
        System.out.println(RESULT_MESSAGE);

        printPlayers(players);
        printLadder(lines);
    }

    private static void printPlayers(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            appendName(sb, player);
            appendBlankName(sb, player);
        }

        System.out.println(sb);
    }

    private static void appendName(StringBuilder sb, Player player) {
        String name = player.getName();
        sb.append(name);
    }

    private static void appendBlankName(StringBuilder sb, Player player) {
        int nameLength = MAX_NAME_LENGTH - player.getName().length();

        if (nameLength != 0) {
            for (int i = 0; i < nameLength; i++) {
                sb.append(BLANK);
            }
        }
    }

    private static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            String sb = LADDER_HEIGHT_DRAWING + line.drawLine();

            System.out.println(sb);
        }
    }
}
