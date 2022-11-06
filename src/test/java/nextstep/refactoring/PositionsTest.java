package nextstep.refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionsTest {

    private Positions positions;

    @BeforeEach
    void setUp() {
        positions = new Positions(4, new TrueGenerator());
    }

    @Test
    void move() {
        assertThat(positions.move(2)).isEqualTo(3);
    }

    @Test
    void moveLastPosition() {
        assertThat(positions.move(3)).isEqualTo(2);
    }

    @Test
    void moveInvalidIndex() {
        assertThatThrownBy(() -> positions.move(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
