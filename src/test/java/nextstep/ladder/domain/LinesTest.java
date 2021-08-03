package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가로줄들")
class LinesTest {

    @DisplayName("[성공] 추가")
    @Test
    public void add() {
        // given
        int height = 5;

        // when
        Lines lines = new Lines(height);
        lines.add();
        lines.add();

        // then
        assertThat(lines.size()).isEqualTo(2);
    }
}
