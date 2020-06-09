package nextstep.ladder.view;

import java.util.List;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.player.Player;

class LadderView {

    void printLadder(List<Player> players, List<String> prizes, List<Line> lines) {
        players.forEach(this::printPlayer);
        System.out.println();

        lines.forEach(this::printLine);

        prizes.forEach(this::printPrize);
        System.out.println("\n");
    }

    private void printPrize(String prize) {
        System.out.print(String.format("%6s", prize));
    }

    private void printPlayer(Player player) {
        System.out.print(String.format("%6s", player.getName()));
    }

    private void printLine(Line line) {
        StringBuilder builder = new StringBuilder();
        builder.append("     ");

        line.getPoints().forEach(point -> {
            builder.append('|').append(point.isRight() ? "-----" : "     ");
        });

        System.out.println(builder.toString());
    }
}
