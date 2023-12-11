package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

public class ResultView {
    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toStringResult());
    }

    public static void printResultPerPlayer(Ladder ladder, String name) {
        System.out.println(ladder.getGameResultPerPlayer(name));
    }
}
