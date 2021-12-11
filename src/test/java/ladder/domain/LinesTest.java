package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("Lines 생성자 테스트")
    void constructor() {
        assertThat(new Lines(Arrays.asList(new Line(Arrays.asList(new Point(false, true), new Point(false, false))))))
                .isEqualTo(new Lines(Arrays.asList(new Line(Arrays.asList(new Point(false, true), new Point(false, false))))));
    }
}
