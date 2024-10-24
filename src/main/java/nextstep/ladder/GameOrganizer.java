package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.LadderResultGroup;
import nextstep.ladder.domain.result.MatchResult;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerGroup;

import java.util.List;

public class GameOrganizer {

    public static GameOrganizer getInstance() {
        return GameOrganizerHolder.INSTANCE;
    }

    public MatchResult play(PlayerGroup playerGroup, LadderResultGroup ladderResultGroup, Ladder ladder) {
        List<Player> result = playerGroup.play(ladder);
        return ladderResultGroup.matchResult(result);
    }

    private static class GameOrganizerHolder {
        private static final GameOrganizer INSTANCE = new GameOrganizer();
    }
}
