package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CoordinateTest {
    @Test
    @DisplayName("좌표값검증")
    void coordinate() {
        Coordinate coordinate1 = new Coordinate(1, 1);
        Coordinate coordinate2 = new Coordinate(1, 2);
        assertThat(coordinate1).isNotEqualTo(coordinate2);
    }
}
