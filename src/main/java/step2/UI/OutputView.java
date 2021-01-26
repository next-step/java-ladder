package step2.UI;

import step2.Ladder;
import step2.Player;
import step2.Point;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE ="실행결과";
    private static final String LADDER_HEIGHT_DRAWING = "|";
    private static final String LADDER_LINE_DRAWING = "-----";
    private static final String LADDER_NO_LINE_DRAWING = "     ";
    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    public static void outputView(Ladder ladder, List<Player> players) {
        System.out.println(RESULT_MESSAGE);

        printPlayers(players);
        printLadder(ladder);
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

    private static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            // 라인
            StringBuilder sb = new StringBuilder();
            sb.append(LADDER_HEIGHT_DRAWING);

            for (Point point : ladder.getLines().get(i).getPoints()) {
                if (point.isPoint()) {
                    sb.append(LADDER_LINE_DRAWING);
                } else {
                    sb.append(LADDER_NO_LINE_DRAWING);
                }
                sb.append(LADDER_HEIGHT_DRAWING);
            }

            System.out.println(sb);
        }
    }
}
