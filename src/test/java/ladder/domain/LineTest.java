package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("연속으로 Bridge가 생성될 수 없다.")
    void cantNotMakeContinuousBridge() {
        assertThatThrownBy(() -> new Line(Arrays.asList(new Bridge(true), new Bridge(true))))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Line(Arrays.asList(new Bridge(true), new Bridge(false), new Bridge(true), new Bridge(true))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
