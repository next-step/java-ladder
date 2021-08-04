package nextstep.ladder.ladder;

import nextstep.ladder.exception.NotMatchedSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderPrizesTest {

    @DisplayName("플레이어 수와 실행결과 수가 다른 경우 에러가 발생한다.")
    @Test
    void player_prize_size_not_matched() {
        assertThatThrownBy(() -> LadderPrizes.of("pobi,honux,crong,jk", "꽝,5000,꽝"))
                .isInstanceOf(NotMatchedSizeException.class);
    }
}