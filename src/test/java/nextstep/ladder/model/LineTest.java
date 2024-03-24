package nextstep.ladder.model;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void create() {
        Line line = Line.from(true, false, true);
        assertThat(line).isEqualTo(Line.from(true, false, true));
    }

    @Test
    void 인원수가_2명_미만인경우_예외던진다() {
        assertThatThrownBy(() -> Line.from(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 라인은_연속적으로_연결할수없다() {
        assertThatThrownBy(() -> Line.from(false, true, true))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Line.from(true, true, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @RepeatedTest(10)
    void 사다리_라인이_연속으로_연결되는_경우는_없다() {
        assertThatNoException()
                .isThrownBy(() -> Line.from(3));
    }

}
