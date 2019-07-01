package nextstep.step3.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
public class WinTest {
    @DisplayName("실행결과 이름을 가지고 온다.")
    @Test
    void getName() {
        Win win = Win.of("꽝");
        assertThat(win.getWin()).isEqualTo("꽝");
    }

    @DisplayName("결과 생성 예외상황 - null")
    @Test
    void createWinNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Win win = Win.of(null);
        }).withMessageContaining("결과가 입력이 안되었습니다.");
    }

    @DisplayName("결과 생성 예외상황 - Empty")
    @Test
    void createWinEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Win win = Win.of("");
        }).withMessageContaining("결과가 입력이 안되었습니다.");
    }

    @DisplayName("숫자로 생성")
    @Test
    void createWinInteger() {
            Win win = Win.of(1000);
            assertThat(win.getWin()).isEqualTo("1000");
    }
}
