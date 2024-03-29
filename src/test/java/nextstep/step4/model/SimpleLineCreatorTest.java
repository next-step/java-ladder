package nextstep.step4.model;

import nextstep.step4.api.LineCreator;
import org.junit.jupiter.api.Test;

import static nextstep.step4.model.SimpleLineCreator.MIN_COUNT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class SimpleLineCreatorTest {

    @Test
    void create() {
        LineCreator factory = new SimpleLineCreator();
        assertThatNoException()
                .isThrownBy(() -> factory.create(3));
    }

    @Test
    void 인원수가_2미만인경우_예외를_던진다() {
        LineCreator factory = new SimpleLineCreator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> factory.create(1))
                .withMessage("최소 인원은 " + MIN_COUNT + "명 입니다");
    }
}
