package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FloorTest {
    @Test
    void testFloorMove() {
        Floor floor = new Floor(Arrays.asList(true, false, true));
        assertThat(floor.move(0)).isEqualTo(1);
        assertThat(floor.move(1)).isEqaulTo(0);
        assertThat(floor.move(2)).isEqaulTo(3);
        assertThat(floor.move(3)).isEqaulTo(2);
    }
}
