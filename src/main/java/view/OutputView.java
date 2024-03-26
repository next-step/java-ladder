package view;

import domain.Line;
import domain.Players;

import java.util.List;

public class OutputView {
    private static final String TRUE_LINE = "-----|";
    private static final String FALSE_LINE = "     |";

    public void printPlayers(Players players) {
        System.out.println(players);
    }

    public void printLadder(List<Line> lines) {
        lines
            .forEach(line -> {
                StringBuilder sb = new StringBuilder();
                sb.append("|");
                line.forEach(point-> {
                    if (point) {
                        sb.append(TRUE_LINE);
                        return;
                    }
                    sb.append(FALSE_LINE);
                });
                System.out.println(sb);
            });
    }
}
