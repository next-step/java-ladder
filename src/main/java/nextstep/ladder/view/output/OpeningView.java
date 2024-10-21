package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.GameOrganizer;
import nextstep.ladder.domain.Ladder;

public class OpeningView implements Visible {

    @Override
    public void view(GameOrganizer gameOrganizer, Ladder ladder) {
        System.out.println();
        System.out.println("실행결과물");
        System.out.println();
    }
}
