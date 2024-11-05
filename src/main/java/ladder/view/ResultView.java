package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Players;

public class ResultView {
    private final Ladder ladder;

    public ResultView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void renderLadder() {
        System.out.println("실행결과");
        System.out.println(ladder.toLadderString());
    }
}
