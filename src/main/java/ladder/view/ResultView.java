package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Player;

import java.util.List;

public class ResultView {

    public void printNames(List<Player> names) {
        for (Player player : names) {
            System.out.print(player.toString());
        }
        System.out.println();
    }

    public void printLadder(Ladder ladder) {
        int ladderHeight = ladder.ladderHeight();
        for(int i = 0; i < ladderHeight; i++) {
            System.out.println(ladder.getLine(i).toString());
        }
    }
}
