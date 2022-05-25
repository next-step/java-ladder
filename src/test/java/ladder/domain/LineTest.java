package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    void consecutiveTrueIsNotAllowed() {
        assertThatThrownBy(() -> new Line(Arrays.asList(true, true, false, true))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void withoutConsecutiveTrueCanCreateLine() {
        assertThat(new Line(Arrays.asList(true, false, false, true))).isInstanceOf(Line.class);
    }

    @Test
    void validateThrowErrorWithConsecutiveTrue() {
        assertThatThrownBy(() -> Line.validate(Arrays.asList(false, true, true))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void nextOfTrueReturnsFalse() {
        assertThat(Line.next(true)).isFalse();
    }
}
