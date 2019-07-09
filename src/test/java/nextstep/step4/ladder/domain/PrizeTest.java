package nextstep.step4.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 22:16
 */
public class PrizeTest {
    @DisplayName("실행결과 이름을 가지고 온다.")
    @Test
    void getName() {
        Prize prize = Prize.of("꽝");
        assertThat(prize.getPrize()).isEqualTo("꽝");
    }

    @DisplayName("결과 생성 예외상황 - null, Empty")
    @ParameterizedTest
    @NullAndEmptySource
    void createWinNull(String prize) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Prize.of(prize);
        }).withMessageContaining("결과가 입력이 안되었습니다.");
    }

    @DisplayName("숫자로 생성")
    @Test
    void createWinInteger() {
        Prize prize = Prize.of(1000);
        assertThat(prize.getPrize()).isEqualTo("1000");
    }
}
