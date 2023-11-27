package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @DisplayName("참가자 수 -1 만큼의 계단공간이 생긴다.")
    @Test
    void 계단공간_생성() {
        Line line = new Line(5);
        Assertions.assertThat(line.getLine().size()).isEqualTo(4);
    }
}