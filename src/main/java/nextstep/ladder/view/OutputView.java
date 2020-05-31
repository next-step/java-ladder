package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;

public class OutputView {

    public void printResult(List<Player> players, List<Line> lines){
        System.out.println("실핼결과\n");

        players.forEach(this::printPlayer);

        System.out.println();

        lines.forEach(this::printLine);
    }

    private void printPlayer(Player player){
        System.out.print(String.format("%6s", player.getName()));
    }

    private void printLine(Line line) {
        System.out.print("     |");
        line.getPoints().forEach(point -> {
            System.out.print(point.hasLadder() ? "-----" : "     ");
            System.out.print("|");
        });
        System.out.println();
    }
}
