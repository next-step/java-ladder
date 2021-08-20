package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("사다리 높이 입력 성공 테스트")
    void 사다리_높이_입력_성공_테스트() {
        Line line = Line.of(5);
        assertThat(line).isEqualTo(Line.of(5));
    }

    @Test
    @DisplayName("사다리 높이 입력 실패 테스트")
    void 사다리_높이_입력_실패_테스트() {
        assertThatThrownBy(() -> Line.of(1))
                .isInstanceOf(RuntimeException.class);
    }

}
