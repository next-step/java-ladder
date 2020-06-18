package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointsTest {

    @Test
    @DisplayName("points 생성 테스트")
    void create() {
        assertThatCode(() -> Points.newInstance(2, () -> true)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("points 생성 에외 테스트 - 위치가 2보다 작으면 예외가 발생한다.")
    void exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Points.newInstance(1, () -> true));
    }

    @Test
    @DisplayName("points move 결과 테스트")
    void move() {
        int position = 1;
        Points points = Points.newInstance(2, () -> true);
        assertThat(points.move(position)).isEqualTo(0);
    }
}
