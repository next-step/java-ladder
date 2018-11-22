package model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private Position position;

    @Before
    public void setUp() throws Exception {
    
    }

    @Test
    public void moveStraight() {
        position = Position.of(Positive.of(0), Direction.STRAIGHT);
        
        assertThat(position.move()).isEqualTo(Positive.of(0));
    }

    @Test
    public void moveLeft() {
        position = Position.of(Positive.of(5), Direction.LEFT);
        assertThat(position.moveLeft()).isEqualTo(Positive.of(4));
    }

    @Test
    public void moveRight() {
        position = Position.of(Positive.of(5), Direction.RIGHT);
        assertThat(position.moveRight()).isEqualTo(Positive.of(6));
    }

}