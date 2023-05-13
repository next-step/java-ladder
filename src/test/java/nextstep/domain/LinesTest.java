package nextstep.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @Test
    void 라인들을_생성한다() {
        // given & when
        Lines lines = new Lines(4, 3);

        // then
        assertThat(lines.getLines().size()).isEqualTo(3);
    }
}
