package game.ladder.view;

import game.ladder.domain.Ladder;

public class OutputView {
    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.makeStringLadder());
    }
}
