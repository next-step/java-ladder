package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.PlayerGroup;

public interface Visible {

    void view(final PlayerGroup playerGroup, final Ladder ladder);
}
