package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointsTest {

    @Test
    @DisplayName("points 생성 테스트")
    void create() {
        assertThatCode(() -> Points.newInstance(2, new DirectionRandomPredicate()));
    }

    @Test
    @DisplayName("points 생성 에외 테스트 - 위치가 2보다 작으면 예외가 발생한다.")
    void exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Points.newInstance(1, new DirectionRandomPredicate()));
    }
}
