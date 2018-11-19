package ladder.view;

import ladder.domain.*;

public class ResultView {
    public static void printResult(Players players, Ladder ladder) {
        System.out.println("실행 결과");
        System.out.println(toPlayers(players));
        System.out.println(toStringLines(ladder));

    }

    private static String toStringLines(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladder.getLines()) {
            sb.append("     ");
            toStringPoints(sb, line);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void toStringPoints(StringBuilder sb, Line line) {
        for (Point point : line.getPoints()) {
            if (point.hasaWidthLine()) {
                sb.append("|-----");
                continue;
            }
            sb.append("|     ");
        }
    }

    private static String toPlayers(Players players) {
        StringBuilder sb = new StringBuilder();
        for (Player player: players.getPlayers()) {
            sb.append(String.format("%5s ", player.getName()));
        }
        return sb.toString();
    }
}
