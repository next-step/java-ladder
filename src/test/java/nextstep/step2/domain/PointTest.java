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
            () -> assertThat(Point.create(new RandomPointCreationStrategy())).isInstanceOf(Point.class),
            () -> assertThat(Point.create(() -> true)).isEqualTo(Point.create(true)).hasSameHashCodeAs(Point.create(true)),
            () -> assertThat(Point.create(() -> false)).isEqualTo(Point.create(false)).hasSameHashCodeAs(Point.create(false))
        );
    }
}
