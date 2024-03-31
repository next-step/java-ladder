package nextstep.step4.model;

import org.junit.jupiter.api.Test;

import static nextstep.step4.model.LadderFactory.MIN_HEIGHT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LadderFactoryTest {

    @Test
    void create() {
        assertThatNoException()
                .isThrownBy(() -> LadderFactory.of(3, 3));
    }

    @Test
    void 최소높이1미만인경우_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderFactory.of(0, 2))
                .withMessage("최소 높이는 " + MIN_HEIGHT + " 입니다");
    }
}
