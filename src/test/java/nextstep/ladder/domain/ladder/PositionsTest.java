package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionsTest {

    @Test
    @DisplayName("positions 생성 테스트")
    void create() {
        assertThatCode(() -> Positions.newInstance(2, new DirectionRandomPredicate()));
    }

    @Test
    @DisplayName("positions 생성 에외 테스트 - 위치가 2보다 작으면 예외가 발생한다.")
    void exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Positions.newInstance(1, new DirectionRandomPredicate()));
    }
}
