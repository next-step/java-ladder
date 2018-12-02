import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DirectionTest {

    @Test
    public void isLeft() {
        assertThat(Direction.LEFT.isLeft()).isTrue();
    }

    @Test
    public void isLeft_오른쪽() {
        assertThat(Direction.RIGHT.isLeft()).isFalse();
    }

    @Test
    public void isRight() {
        assertThat(Direction.RIGHT.isRight()).isTrue();
    }

    @Test
    public void isRight_왼쪽() {
        assertThat(Direction.LEFT.isRight()).isFalse();
    }

    @Test
    public void isStraight() {
        assertThat(Direction.STRAIGHT.isStraight()).isTrue();
    }
}