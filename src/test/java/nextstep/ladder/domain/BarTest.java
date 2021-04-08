package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BarTest {

    @DisplayName("Point 객체 생성 테스트")
    @Test
    void create_Point_생성테스트() {
        // given
        Bar bar = Bar.valueOf(true);
        // when
        Bar expected = Bar.valueOf(true);
        // then
        assertThat(bar).isEqualTo(expected);
    }
}
