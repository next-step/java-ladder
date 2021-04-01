package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("Line 생성 테스트")
    @Test
    void create_라인_생성테스트() {
        // given
        Line line = Line.valueOf(2);
        // when
        Line expected = Line.valueOf(2);
        // then
        assertThat(line).isEqualTo(expected);
    }
}
