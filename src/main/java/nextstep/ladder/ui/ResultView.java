package nextstep.ladder.ui;

import nextstep.ladder.Ladder;

public class ResultView {
    public static void printResults(Ladder ladder) {
        System.out.println("실행 결과\n");
        System.out.println(ladder.getPlayers());
        System.out.println(ladder);
    }
}
