package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private Position position;

    @Before
    public void setUp() throws Exception {
        position = new Position(Positive.of(5), Positive.of(5));
    }

    @Test
    public void moveDown() {
        position.moveDown();
        assertThat(position.getY().getNum()).isEqualTo(4);
    }

    @Test
    public void moveLeftDown() {
        position.moveLeftDown();
        assertThat(position.getX().getNum()).isEqualTo(4);
        assertThat(position.getY().getNum()).isEqualTo(4);
    }

    @Test
    public void moveRightDown() {
        position.moveRightDown();
        assertThat(position.getX().getNum()).isEqualTo(6);
        assertThat(position.getY().getNum()).isEqualTo(4);
    }

    @Test
    public void isZeroY() {
        position = new Position(Positive.of(5), Positive.of(0));
        assertThat(position.isZeroY()).isTrue();
    }
}