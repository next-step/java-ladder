package ladder.domain.person;

import ladder.domain.ladder.HorizontalLineDirection;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    @Test
    void create() {
        Position position = new Position(1, 1);

        assertThat(position).isEqualTo(new Position(1, 1));
    }

    @Test
    void getX() {
        assertThat(new Position(1, 1).x()).isEqualTo(1);
    }

    @Test
    void getY() {
        assertThat(new Position(1, 1).y()).isEqualTo(1);
    }

    @Test
    void descend() {
        Position descend = new Position(1, 1).descend(HorizontalLineDirection.NONE);
        assertThat(descend).isEqualTo(new Position(1, 2));
    }
}
