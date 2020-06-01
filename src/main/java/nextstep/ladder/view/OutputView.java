package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.line.Line;

public class OutputView {

    public void printResult(List<Player> players, List<Line> lines) {
        System.out.println("실핼결과\n");

        players.forEach(this::printPlayer);

        System.out.println();

        lines.forEach(this::printLine);
    }

    private void printPlayer(Player player) {
        System.out.print(String.format("%6s", player.getName()));
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append("     |");

        line.getPoints().forEach(point -> {
            builder.append(point.hasLadder() ? "-----" : "     ")
                .append('|');
        });

        System.out.println(builder.toString());
    }
}
