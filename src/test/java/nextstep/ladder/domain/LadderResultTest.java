package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {

    @DisplayName("결과 조회가 잘 되는지")
    @Test
    void getResultTest() {
        LadderResult result = new LadderResult(List.of("꽝", "5000", "3000"));
        assertThat(result.getResult(0)).isEqualTo("꽝");
        assertThat(result.getResult(1)).isEqualTo("5000");
        assertThat(result.getResult(2)).isEqualTo("3000");
    }

    @DisplayName("잘못된 위치의 결과를 조회 시 예외가 잘 발생하는지")
    @Test
    void getResultWithInvalidPosition() {
        LadderResult result = new LadderResult(List.of("꽝", "5000", "3000"));
        assertThatThrownBy(() -> result.getResult(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
