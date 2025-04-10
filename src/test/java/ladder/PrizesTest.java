package ladder;

import ladder.domain.Prizes;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {

    @Test
    public void 위치_정보를_기반으로_경품의_정보를_반환한다() {
        Prizes prizes = Prizes.of(List.of("꽝", "5000", "꽝", "3000"));
        assertThat(prizes.getPrizeByPosition(0).getValue()).isEqualTo("꽝");
        assertThat(prizes.getPrizeByPosition(1).getValue()).isEqualTo("5000");
        assertThat(prizes.getPrizeByPosition(2).getValue()).isEqualTo("꽝");
        assertThat(prizes.getPrizeByPosition(3).getValue()).isEqualTo("3000");
    }

}
