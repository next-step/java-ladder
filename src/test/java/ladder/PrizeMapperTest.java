package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import nextstep.ladder.domain.strategy.BridgeBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeMapperTest {
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
        LadderGame ladderGame = new LadderGame(players, ladder);
        ladderGame.start();
    }

    @Test
    @DisplayName("플레이어가 마지막으로 가진 Point에 따라 상이 주어진다.")
    void x() {
        Prizes prizes = new Prizes(Arrays.asList("꽝", "5000", "꽝", "3000"));
        PrizeMapper prizeMapper = new PrizeMapper(prizes, players);

        assertThat(prizeMapper.getPlayerPrizeResult("pobi").get(0)).isEqualTo("꽝");
        assertThat(prizeMapper.getPlayerPrizeResult("honux").get(0)).isEqualTo("3000");
        assertThat(prizeMapper.getPlayerPrizeResult("crong").get(0)).isEqualTo("꽝");
        assertThat(prizeMapper.getPlayerPrizeResult("jk").get(0)).isEqualTo("5000");
    }
}
