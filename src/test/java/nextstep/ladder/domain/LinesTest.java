package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void createTest() {
        Lines lines = new Lines(2, 2);

        assertThat(lines.getLines()).hasSize(2);
    }

    @DisplayName("필수 기본 연결을 확인한다.")
    @Test
    void connectMinimumTest() {
        Lines lines = new Lines(4, 2);

        assertThat(lines.isAllLineConnected()).isFalse();

        lines.connectMinimum();

        assertThat(lines.isAllLineConnected()).isTrue();
    }

}