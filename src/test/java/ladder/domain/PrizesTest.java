package ladder.domain;

import ladder.exception.PrizeCountNotMatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PrizesTest {

    @DisplayName("입력받은 결과들을 갖고 있다.")
    @Test
    void prizes() {
        int playerCount = 4;
        String input = "꽝,5000,꽝,3000";

        List<Prize> actual = new Prizes(input, playerCount).getPrizes();

        assertThat(actual).hasSize(4);
    }

    @DisplayName("입력받은 결과갯수와 참여자 수가 맞지 않으면 예외를 발생한다.")
    @Test
    void checkAvailablePrizes() {
        int playerCount = 3;
        String input = "꽝,5000,꽝,3000";

        assertThatExceptionOfType(PrizeCountNotMatchException.class).isThrownBy(
                () -> new Prizes(input, playerCount).getPrizes()
        );
    }
}