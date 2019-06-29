package nextstep.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {

    @Test
    @DisplayName("Point 생성")
    void create() {
        assertAll(
            () -> assertThat(new Point()).isInstanceOf(Point.class),
            () -> assertThat(Point.create(new Point())).isInstanceOf(Point.class)
        );
    }
}
