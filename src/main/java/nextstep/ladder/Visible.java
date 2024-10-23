package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MatchResult;

public interface Visible {

    void view(MatchResult matchResult, Ladder ladder);
}
