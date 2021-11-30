package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FloorsTest {
    Floor floorFirst = new Floor(Arrays.asList(true, false, true));
    Floor floorSecond = new Floor(Arrays.asList(false, true, false));
    Floor floorThird = new Floor(Arrays.asList(true, false, false));
    Floor floorFourth = new Floor(Arrays.asList(false, false, true));
    Floors floors = new Floors(Arrays.asList(floorFirst, floorSecond, floorThird, floorFourth));

    @Test
    void testFinalPosition() {
        List<Position> positions = floors.finalPositions(4);
        assertThat(positions.get(0)).isEqualTo(new Position(3));
        assertThat(positions.get(1)).isEqualTo(new Position(1));
        assertThat(positions.get(2)).isEqualTo(new Position(2));
        assertThat(positions.get(3)).isEqualTo(new Position(0));
    }
}
