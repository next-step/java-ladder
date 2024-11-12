package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {
    @DisplayName("사다리 별 라인값 Lines 객체를 생성한다.")
    @Test
    void create() {
        Lines actual = new Lines(List.of(TRUE, FALSE, TRUE));

        assertThat(actual).isEqualTo(new Lines(List.of(TRUE, FALSE, TRUE)));
    }

    @DisplayName("해당 층에 사다리가 놓여있는지 확인한다.")
    @Test
    void contains() {
        Lines lines = new Lines(List.of(TRUE, TRUE, FALSE));

        assertThat(lines.isAlreadySetAt(0)).isTrue();
        assertThat(lines.isAlreadySetAt(2)).isFalse();
    }
}
