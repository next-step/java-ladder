package ladder2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import nextstep.ladder2.domain.NxLadder;
import nextstep.ladder2.domain.builder.TestBuilder;
import nextstep.ladder2.domain.prize.NxPrize;
import nextstep.ladder2.domain.prize.NxPrizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NxPrizesTest {
    @Test
    @DisplayName("미리 입력된 사다리를 타고, 최종 Prize와 적합하게 맵핑되는지 확인한다.")
    void getPrizeAfterRideLadderTest() {
        NxLadder ladder = new NxLadder(5, 4, new TestBuilder());
        NxPrizes prizes = new NxPrizes(Arrays.asList("꽝","5000","꽝","3000"));

        assertThat(prizes.getPrizeByIndex(ladder.ride(0))).isEqualTo(new NxPrize("꽝"));
        assertThat(prizes.getPrizeByIndex(ladder.ride(1))).isEqualTo(new NxPrize("3000"));
        assertThat(prizes.getPrizeByIndex(ladder.ride(2))).isEqualTo(new NxPrize("꽝"));
        assertThat(prizes.getPrizeByIndex(ladder.ride(3))).isEqualTo(new NxPrize("5000"));
    }
}
