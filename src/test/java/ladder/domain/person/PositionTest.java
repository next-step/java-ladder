package ladder.domain.person;

import ladder.domain.ladder.HorizontalLineDirection;
import ladder.domain.ladder.MoveHorizontalDirection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PositionTest {

    private Position position;

    @BeforeEach
    void setUp() {
        this.position = new Position(1, 1);
    }

    @Test
    void create() {
        assertThat(this.position).isEqualTo(new Position(1, 1));
    }

    @Test
    void getX() {
        assertThat(this.position.x()).isEqualTo(1);
    }

    @Test
    void getY() {
        assertThat(this.position.y()).isEqualTo(1);
    }

    @Test
    void descend() {
        Position descendLeft = this.position
                .descend(new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.LEFT));
        Position descendNone = this.position
                .descend(new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE));
        Position descendRight = this.position
                .descend(new MoveHorizontalDirection(HorizontalLineDirection.NONE, HorizontalLineDirection.RIGHT));

        Assertions.assertAll(
                () -> assertThat(descendLeft).isEqualTo(new Position(0, 2)),
                () -> assertThat(descendNone).isEqualTo(new Position(1, 2)),
                () -> assertThat(descendRight).isEqualTo(new Position(2, 2)));
    }
}
