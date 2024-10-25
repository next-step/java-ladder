package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("라인 객체 올바르게 생성되는지 테스트")
    void 라인_생성_성공_테스트() {
        Line line = new Line(false, true, false, true);

        assertThat(line).isEqualTo(new Line(4, ()->true));
    }

    @Test
    @DisplayName("연속된 true 값으로 라인 생성 시 예외 발생 테스트")
    void 라인_생성_연속_실패_테스트() {
        assertThatThrownBy(() -> new Line(false, false, true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("연속으로 중복 될 수 없는 값이 존재합니다.");
    }

    @Test
    @DisplayName("빈 라인 객체 생성 시 예외 발생 테스트")
    void 라인_생성_실패_테스트() {
        assertThatThrownBy(() -> new Line())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("라인은 비어있을 수 없습니다.");
    }

}
