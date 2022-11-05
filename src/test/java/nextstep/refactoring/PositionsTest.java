package nextstep.refactoring;

import nextstep.ladder.TrueGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionsTest {

    private Positions positions;

    @BeforeEach
    void setUp() {
        positions = new Positions(5, new TrueGenerator());
    }

    @Test
    void move() {
        assertThat(positions.move(2)).isEqualTo(3);
    }

    @Test
    void moveLastPosition() {
        assertThat(positions.move(4)).isEqualTo(3);
    }

    @Test
    void moveInvalidIndex() {
        assertThatThrownBy(() -> positions.move(6))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
