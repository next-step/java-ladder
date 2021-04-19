package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Prize;
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

        assertThat(prizeMapper.getPrizeByPlayerName("pobi")).isEqualTo(new Prize("꽝"));
        assertThat(prizeMapper.getPrizeByPlayerName("honux")).isEqualTo(new Prize("3000"));
        assertThat(prizeMapper.getPrizeByPlayerName("crong")).isEqualTo(new Prize("꽝"));
        assertThat(prizeMapper.getPrizeByPlayerName("jk")).isEqualTo(new Prize("5000"));
    }
}
