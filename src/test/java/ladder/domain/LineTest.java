package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("생성 된 라인의 포인트 수는 입력한 수와 같다.")
    @Test
    void create_lines() {
        // given
        int count = 5;

        // when
        Line line = new Line(count, () -> true);

        // then
        assertThat(line.currentPoints()).hasSize(count);
    }

}
