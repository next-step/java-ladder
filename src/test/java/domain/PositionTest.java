package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {
    List<Boolean> floor = Arrays.asList(true, false, true);

    @DisplayName("Test Position is movable to left")
    @Test
    void testIsMovableLeft() {
        assertThat(new Position(0).isMovableLeft(floor)).isFalse();
        assertThat(new Position(1).isMovableLeft(floor)).isTrue();
        assertThat(new Position(2).isMovableLeft(floor)).isFalse();
        assertThat(new Position(3).isMovableLeft(floor)).isTrue();
    }

    @DisplayName("Test Position moves left")
    @Test
    void testMoveLeft() {
        assertThat(new Position(1).moveLeft()).isEqualTo(new Position(0));
    }

    @DisplayName("Test Position is movable to right")
    @Test
    void testIsMovableRight() {
        assertThat(new Position(0).isMovableRight(floor)).isTrue();
        assertThat(new Position(1).isMovableRight(floor)).isFalse();
        assertThat(new Position(2).isMovableRight(floor)).isTrue();
        assertThat(new Position(3).isMovableRight(floor)).isFalse();
    }

    @DisplayName("Test Position moves right")
    @Test
    void testMoveRight() {
        assertThat(new Position(1).moveRight()).isEqualTo(new Position(2));
    }

    @DisplayName("Exception when position is out of bounds")
    @Test
    void testOutOfBounds() {
        assertThatThrownBy(() -> new Position(-1).isMovableLeft(floor)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> new Position(4).isMovableLeft(floor)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> new Position(-1).isMovableRight(floor)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() -> new Position(4).isMovableRight(floor)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
