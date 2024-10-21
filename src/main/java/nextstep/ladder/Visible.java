package nextstep.ladder;

import nextstep.ladder.domain.GameOrganizer;
import nextstep.ladder.domain.Ladder;

public interface Visible {

    void view(GameOrganizer gameOrganizer, Ladder ladder);
}
