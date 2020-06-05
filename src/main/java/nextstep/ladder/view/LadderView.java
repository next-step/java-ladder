package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.line.Line;

class LadderView {

    void printLadder(Ladder ladder) {

        ladder.getPlayers().forEach(this::printPlayer);
        System.out.println();

        ladder.getLines().forEach(this::printLine);

        ladder.getPrizes().forEach(this::printPrize);
        System.out.println();
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
            builder.append('|').append(point.hasRight() ? "-----" : "     ");
        });

        System.out.println(builder.toString());
    }
}
