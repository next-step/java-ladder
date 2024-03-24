package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 인원은 " + Line.MIN_COUNT + "명 입니다");
    }

    @Test
    void 라인은_연속적으로_연결할수없다() {
        assertThatThrownBy(() -> Line.from(false, true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인이 겹치지 않아야 합니다");

        assertThatThrownBy(() -> Line.from(true, true, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("라인이 겹치지 않아야 합니다");
    }

}
