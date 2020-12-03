package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    @Test
    void ofTest() {
        Points points = Points.of(Length.of(3));
        assertThat(points.stream().count()).isEqualTo(3);
    }

}
