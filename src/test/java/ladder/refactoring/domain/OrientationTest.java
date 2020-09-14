package ladder.refactoring.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {
    @Test
    void next_test() {
        int orientation = Orientation.next(false, true);
        assertThat(orientation).isEqualTo(1);
    }
}
