package nextstep.ladder.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WidthTest {

    @DisplayName("인자로 너비 값을 받아 생성한다.")
    @Test
    void createAxisX() {
        assertThat(new Width(0)).isEqualTo(new Width(0));
    }
}
