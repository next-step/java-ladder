package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FloorTest {

    @DisplayName("test move function of Floor class")
    @Test
    void testFloorMove() {
        Floor floorFirst = new Floor(Arrays.asList(true, false, true));
        assertThat(floorFirst.move(new Position(0))).isEqualTo(new Position(1));
        assertThat(floorFirst.move(new Position(1))).isEqualTo(new Position(0));
        assertThat(floorFirst.move(new Position(2))).isEqualTo(new Position(3));
        assertThat(floorFirst.move(new Position(3))).isEqualTo(new Position(2));

        Floor floorSecond = new Floor(Arrays.asList(false, true, false));
        assertThat(floorSecond.move(new Position(0))).isEqualTo(new Position(0));
        assertThat(floorSecond.move(new Position(1))).isEqualTo(new Position(2));
        assertThat(floorSecond.move(new Position(2))).isEqualTo(new Position(1));
        assertThat(floorSecond.move(new Position(3))).isEqualTo(new Position(3));
    }
}
