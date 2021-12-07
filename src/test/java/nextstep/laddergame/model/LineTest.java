package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("참가자 수가 주어졌을 때 해당하는 line을 생성하는지 검증")
    @Test
    void constructTest() {
        Line line = new Line(10);
        assertThat(line.getBridges().size()).isEqualTo(9);
    }
}
