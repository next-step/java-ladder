package nextstep.ladder.domain;

import nextstep.ladder.GameOrganizer;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderLine;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.PlayerGroup;
import nextstep.ladder.domain.result.LadderResultGroup;
import nextstep.ladder.domain.result.MatchResult;
import nextstep.ladder.dto.PlayerResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOrganizerTest {

    @Test
    void get_match_result() {
        PlayerGroup playerGroup = new PlayerGroup("pobi,honux,crong,jk");
        LadderResultGroup ladderResultGroup =
                LadderResultGroup.of("꽝, 5000, 3000, 꽝", playerGroup.count());
        Ladder ladder = new Ladder(List.of(
                new LadderLine(List.of(true, false, false)),
                new LadderLine(List.of(true, false, false)),
                new LadderLine(List.of(true, false, false)),
                new LadderLine(List.of(false, false, false))));

        MatchResult matchResult = GameOrganizer.getInstance().play(playerGroup, ladderResultGroup, ladder);

        assertThat(matchResult.allPlayResults()).containsExactlyInAnyOrder(
                new PlayerResult(new Player("pobi", 1), "5000"),
                new PlayerResult(new Player("honux", 0), "꽝"),
                new PlayerResult(new Player("crong", 2), "3000"),
                new PlayerResult(new Player("jk", 3), "꽝")
        );
    }
}
