package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.MatchResult;

public class OpeningView implements Visible {

    @Override
    public void view(MatchResult matchResult, Ladder ladder) {
        System.out.println();
        System.out.println("실행결과물");
        System.out.println();
    }
}
