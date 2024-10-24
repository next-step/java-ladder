package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.MatchResult;

public interface Visible {

    void view(MatchResult matchResult, Ladder ladder);
}
