package ladder.view;

import ladder.domain.*;

public class ResultView {
    public static void printResult(Players players, Ladder ladder, Results result) {
        System.out.println("실행 결과");
        System.out.println(toPlayers(players));
        System.out.println(toStringLines(ladder));
        System.out.println(toResults(result));

    }

    private static String toResults(Results results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results.getResults()) {
            sb.append(String.format("%5s ", result.getName()));
        }
        return sb.toString();
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
            if (point.canMoveRight()) {
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
