package ladder.view.output;

import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;
import ladder.model.ladder.Point;
import ladder.model.player.Players;

public class OutputView {

    public static void printResult(Players players, Ladder ladder) {
        System.out.println("\n실행결과\n");

        printPlayerNames(players);
        printLadder(ladder);
    }

    private static void printPlayerNames(Players players) {
        players.getPlayers()
                .forEach(p -> System.out.printf("%-6s", p.getName()));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Point point : line.getPoints()) {
            sb.append("|").append(point.hasLine() ? "-----" : "     ");
        }
        sb.append("|");
        System.out.println(sb);
    }

}
