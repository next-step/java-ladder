package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;

public class ResultView {

    public void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println();
        System.out.println(LadderFormatter.format(ladder));
    }

}
