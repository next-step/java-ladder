package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void constructor() {
        assertThat(Point.of(true)).isEqualTo(Point.of(true));
    }
}
