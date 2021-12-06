package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FloorsTest {
    public static final Floor FLOOR_FIRST = new Floor(Arrays.asList(true, false, true));
    public static final Floor FLOOR_SECOND = new Floor(Arrays.asList(false, true, false));
    public static final Floor FLOOR_THIRD = new Floor(Arrays.asList(true, false, false));
    public static final Floor FLOOR_FOURTH = new Floor(Arrays.asList(false, false, true));
    public static final Floors FLOORS = new Floors(Arrays.asList(FLOOR_FIRST, FLOOR_SECOND, FLOOR_THIRD, FLOOR_FOURTH));

    @Test
    void testFinishedPosition() {
        assertThat(FLOORS.finishedPosition(new Position(0))).isEqualTo(new Position(3));
        assertThat(FLOORS.finishedPosition(new Position(1))).isEqualTo(new Position(1));
        assertThat(FLOORS.finishedPosition(new Position(2))).isEqualTo(new Position(2));
        assertThat(FLOORS.finishedPosition(new Position(3))).isEqualTo(new Position(0));
    }
}
