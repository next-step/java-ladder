package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

public class ResultView {

    private static final String LINE = "|";
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY = "     ";

    public void ladderView(Ladder ladder, Players players){

        players.getPlayers().forEach(p -> {
            int spacesToAdd = 6 - p.getPlayer().length();
            StringBuilder result = new StringBuilder(p.getPlayer());
            result.append(" ".repeat(spacesToAdd));
            System.out.print(result);
        });
        System.out.println();
        ladder.getLines().stream().forEach(this::drawLadder);
    }

    private void drawLadder(Line line) {
        System.out.print(LINE);
        line.stream()
            .forEach(b -> {
                if (b) {
                    System.out.print(LADDER_LINE + LINE);
                } else {
                    System.out.print(LADDER_EMPTY + LINE);
                }
            });
        System.out.print("\n");
    }

}
