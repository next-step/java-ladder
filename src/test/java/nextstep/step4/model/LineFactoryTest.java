package nextstep.step4.model;

import org.junit.jupiter.api.Test;

import static nextstep.step4.model.LineFactory.MIN_COUNT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LineFactoryTest {

    @Test
    void create() {
        assertThatNoException()
                .isThrownBy(() -> LineFactory.from(3));
    }

    @Test
    void 인원수가_2미만인경우_예외를_던진다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LineFactory.from(1))
                .withMessage("최소 인원은 " + MIN_COUNT + "명 입니다");
    }
}
