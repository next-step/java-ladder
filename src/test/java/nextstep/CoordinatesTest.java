package nextstep;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CoordinatesTest {
    @Test
    @DisplayName("좌표값들검증")
    void coordinates() {
        Coordinates coordinates = new Coordinates();
        coordinates.add(new Coordinate("bong", 0, 0));
        coordinates.add(new Coordinate("big", 0, 0));
        coordinates.move(0);
        assertThat(coordinates.heights().get(0)).isEqualTo(1);
        assertThat(coordinates.heights().get(1)).isEqualTo(0);

        coordinates.move(0);
        assertThat(coordinates.heights().get(0)).isEqualTo(2);
        assertThat(coordinates.heights().get(1)).isEqualTo(0);

        coordinates.move(1);
        assertThat(coordinates.heights().get(0)).isEqualTo(2);
        assertThat(coordinates.heights().get(1)).isEqualTo(1);
    }
}
