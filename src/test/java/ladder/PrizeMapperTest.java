package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.PrizeMapper;
import nextstep.ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeMapperTest {
    @Test
    @DisplayName("플레이어가 마지막으로 가진 Point에 따라 상이 주어진다.")
    void prizeMapperTest() {
        Prizes prizes = new Prizes(Arrays.asList("꽝", "5000", "꽝", "3000"));
        Players players = new Players(Arrays.asList("pobi", "honux", "crong", "jk"));
        PrizeMapper prizeMapper = new PrizeMapper(prizes, players);

        players.updatePlayerPoint(players.findPlayerByName("pobi"), new Point(0));
        players.updatePlayerPoint(players.findPlayerByName("honux"), new Point(3));
        players.updatePlayerPoint(players.findPlayerByName("crong"), new Point(2));
        players.updatePlayerPoint(players.findPlayerByName("jk"), new Point(1));

        assertThat(prizeMapper.getPlayerPrizeResult("pobi").get(0)).isEqualTo("꽝");
        assertThat(prizeMapper.getPlayerPrizeResult("honux").get(0)).isEqualTo("3000");
        assertThat(prizeMapper.getPlayerPrizeResult("crong").get(0)).isEqualTo("꽝");
        assertThat(prizeMapper.getPlayerPrizeResult("jk").get(0)).isEqualTo("5000");
    }
}
