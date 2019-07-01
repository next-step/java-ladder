package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GamePrizeTest {
    @DisplayName("실행결과에 LPAD(6자리 공백) 포함 한 줄 출력")
    @Test
    void getFormattedResultTest() {
        assertThat(new GamePrize("1000, 꽝, 2000, 꽝")
                .getFormattedResult())
                .isEqualTo("  1000     꽝  2000     꽝");
    }

    @DisplayName("Players 이름 중 다섯 자리 초과 존재 시, 예외 발생")
    @Test
    void splitNameTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new GamePrize("1000, 꽝, 탈락된사용자");
        });
    }
}
