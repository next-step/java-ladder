package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class OutputView {
    private static final StringBuilder sb = new StringBuilder();

    public static void printLadder(Players players, Ladder ladder, ResultAmounts resultAmounts) {
        sb.setLength(0);

        appendPersonNames(players);
        appendLadder(ladder);
        appendResultAmounts(resultAmounts);

        System.out.println(sb);
    }

    private static void appendPersonNames(Players players) {
        for (Player player : players) {
            sb.append(String.format("%5s", player));
        }
        sb.append("\n");
    }

    private static void appendLadder(Ladder ladder) {
        for (Line line : ladder) {
            sb.append("   |");
            appendLine(line);
            sb.append("\n");
        }
    }

    private static void appendLine(Line line) {
        for (Point point : line.points()) {
            addPoint(point);
        }
    }

    private static void addPoint(Point point) {
        if (point.isPoint()) {
            sb.append("-----");
            sb.append("|");
        }

        if (!point.isPoint()) {
            sb.append("     ");
            sb.append("|");
        }
    }

    private static void appendResultAmounts(ResultAmounts resultAmounts) {
        for (Amount amount : resultAmounts) {
            sb.append(String.format("%5s", amount));
        }
        sb.append("\n");
    }

    public static void printResult(LadderResult ladderResult) {
        String inputName = "";
        while (!inputName.equals("all")) {
            inputName = InputView.inputPlayer();

            if (inputName.equals("all")) {
                for (Player player : ladderResult.keySet()) {
                    System.out.printf("%s : %s\n", player, ladderResult.get(player));
                }

                continue;
            }

            System.out.printf("%s : %s\n", inputName, ladderResult.get(new Player(inputName)));
        }
    }
}
