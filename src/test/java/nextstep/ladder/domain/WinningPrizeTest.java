package nextstep.ladder.domain;

import nextstep.ladder.domain.wrapper.Height;
import nextstep.ladder.domain.wrapper.Width;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningPrizeTest {

    @AfterEach
    void clear() {
        Coordinate.clear();
    }

    @DisplayName("플레이어를 인자로 받아 해당 플레이어의 당첨 결과를 반환한다.")
    @Test
    void findWinningPrizeBy() {
        // given
        int height = 5;
        Coordinate.init(new Width(4), new Height(height));

        Player player = new Player("홍길동", Coordinate.of(2, 5));
        WinningPrize winningPrize = new WinningPrize(List.of("꽝", "5000", "꽝", "3000"), height);

        // when
        String name = "홍길동";
        String winningResult = winningPrize.findWinningPrizeBy(player);

        // then
        assertThat(winningResult).isEqualTo("꽝");
    }
}
