package nextstep.ladder.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AxisXTest {

    @DisplayName("X축의 값을 생성한다.")
    @Test
    void createAxisX() {
        assertThat(new AxisX(0)).isEqualTo(new AxisX(0));
    }
}
