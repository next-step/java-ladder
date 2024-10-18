package nextstep.ladder.view.output;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.Visible;

public class OpeningView implements Visible {

    @Override
    public void view(final PlayerGroup playerGroup, final Ladder ladder) {
        System.out.println();
        System.out.println("실행결과물");
        System.out.println();
    }
}
