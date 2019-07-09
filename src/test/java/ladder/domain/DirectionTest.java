package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    void firstDirection(){
        assertThat(Direction.first(true)).isEqualTo(Direction.RIGHT);
        assertThat(Direction.first(false)).isEqualTo(Direction.PASS);
    }

    @Test
    void lastDirection(){
        assertThat(Direction.first(true).last()).isEqualTo(Direction.LEFT);
        assertThat(Direction.first(false).last()).isEqualTo(Direction.PASS);
    }

    @Test
    void nextDirection(){
        assertThat(Direction.first(true).next()).isEqualTo(Direction.LEFT);
        assertThat(Direction.first(false)).isNotEqualTo(Direction.LEFT);
    }

}
