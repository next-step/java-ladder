package nextstep.ladder.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AxisYTest {

    @DisplayName("Y축의 값을 생성한다.")
    @Test
    void createAxisX() {
        assertThat(new AxisY(0)).isEqualTo(new AxisY(0));
    }
}