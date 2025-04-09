package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

public class OutputView {

    public static void showLadder(Ladder ladder) {
        System.out.printf("실행 결과%n%n");
        System.out.println(ladder);
    }
}
