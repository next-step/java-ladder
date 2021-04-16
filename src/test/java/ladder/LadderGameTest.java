package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.domain.strategy.BridgeBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    private static Ladder ladder;
    private static Players players;

    @BeforeAll
    @DisplayName("테스트 시나리오 준비--!!")
    static void prepareTestScenario() {
        List<String> predefined = Arrays.asList("0,2", "1", "0", "1", "0,2");
        BridgeBuilder bridgeBuilder = new BridgeBuilder(predefined);

        ladder = new Ladder(5, 4, bridgeBuilder);
        ladder.build();

        players = new Players(Arrays.asList("pobi", "honux", "crong", "jk"));
    }

    @Test
    @DisplayName("이동 후 플레이어 위치를 확인한다.")
    void movePlayersTest() {
        LadderGame ladderGame = new LadderGame(ladder, players);

        ladderGame.start();
        Player pobi = ladderGame.findPlayer("pobi");

        assertThat(pobi.isPlayerInPosition(new Point(0))).isEqualTo(true);
    }
}
