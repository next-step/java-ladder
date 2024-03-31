package view;

import domain.Ladder;
import domain.Players;

import java.util.List;


public class OutputView {
    private static final String TRUE_LINE = "-----|";
    private static final String FALSE_LINE = "     |";

    public void printPlayers(Players players) {
        System.out.println(players);
    }

    public void printLadder(Ladder ladder) {
        ladder
            .forEach(line -> {
                StringBuilder sb = new StringBuilder();
                sb.append("|");
                line.forEach(point-> appendLineByPoint(point, sb));
                System.out.println(sb);
            });
    }

    private void appendLineByPoint(Boolean point, StringBuilder sb) {
        if (point) {
            sb.append(TRUE_LINE);
            return;
        }
        sb.append(FALSE_LINE);
    }

    public void printResults(List<String> results) {
        results.forEach(result -> System.out.print(result + Players.PRINT_SPACE));
        System.out.println();
    }
}
