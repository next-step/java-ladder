package step2.view;

import step2.domain.Ladder;
import step2.domain.LadderGame;

import java.util.List;

public class OutputView {
    private static final String TRUE = "-----|";
    private static final String FALSE = "     |";

    public void printLadderGame(LadderGame ladderGame) {
        final List<Ladder> ladders = ladderGame.ladders();
        StringBuilder sb = new StringBuilder();

        for (Ladder ladder : ladders) {
            sb.append(String.format("%6s", ladder.name()));
        }
        sb.append("\n");

        for (int i = 0; i < ladderGame.ladders().size(); i++) {
            for (Ladder ladder : ladderGame.ladders()) {
                final Boolean point = ladder.line().points().get(i);
                if (point) {
                    sb.append(TRUE);
                }
                else {
                    sb.append(FALSE);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
