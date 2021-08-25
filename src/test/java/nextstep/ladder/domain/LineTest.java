package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("라인의 선 유무배열로 Line 객체를 생성한다.")
    @Test
    void create() {
        assertThat(Line.from(true, false, true)).isEqualTo(Line.from(true, false, true));
    }

    @DisplayName("가로라인 선이 2개 미만일때 에러가 발생한다.")
    @Test
    void validPointCount() {
        assertThatThrownBy(() -> Line.from(true))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Line.from(false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("|-----|-----| 와 같이 가로라인 선이 2개 연속으로 오면 에러가 발생한다.")
    @Test
    void validContinuous() {
        assertThatThrownBy(() -> Line.from(true, true, false))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Line.from(false, true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
