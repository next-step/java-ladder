package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningPrizeTest {

    @DisplayName("위치 값을 인자로 받아 해당하는 당첨결과를 반환한다.")
    @Test
    void findWinningPrizeBy() {
        // given
        WinningPrize winningPrize = new WinningPrize(List.of("꽝", "5000", "꽝", "3000"));

        // when
        int position = 2;
        String prize = winningPrize.prize(position);

        // then
        assertThat(prize).isEqualTo("꽝");
    }
}
