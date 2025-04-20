package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

public class ReviewView {
    private ReviewView() {
    }

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.getPersonNames());
        System.out.println(ladder.getLadderLines());
    }
}
