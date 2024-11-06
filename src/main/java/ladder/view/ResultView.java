package ladder.view;

import ladder.domain.Ladder;

public class ResultView {

    public ResultView() {
    }

    public void renderLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(ladder.toLadderString());
    }
}
