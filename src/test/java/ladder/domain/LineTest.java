package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 라인_이동_테스트() {
        Line line = new Line(false, true, false, true);

        assertThat(line.move(2)).isEqualTo(3);
    }

    @Test
    void 라인_제자리_이동_테스트() {
        Line line = new Line(false, true, false, false);

        assertThat(line.move(3)).isEqualTo(3);
    }

}
