package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void first(){
        Direction direction = Direction.first(true);

        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    public void next() {
        Direction direction = Direction.first(false).next(true);

        assertThat(direction.isRight()).isTrue();
        assertThat(direction.isLeft()).isFalse();
    }


    @Test
    public void last() {
        Direction direction = Direction.first(false).last(true);

        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isTrue();
    }

}