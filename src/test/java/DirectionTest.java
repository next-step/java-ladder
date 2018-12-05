import org.assertj.core.internal.bytebuddy.dynamic.loading.ClassInjector;
import org.junit.Test;

import java.security.DigestInputStream;

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

    @Test
    public void first_오른쪽() {
        assertThat(Direction.first(true).isRight()).isTrue();
    }

    @Test
    public void first_직진() {
        assertThat(Direction.first(false).isStraight()).isTrue();
    }

    @Test
    public void last_직진() {
        assertThat(Direction.LEFT.last()).isEqualTo(Direction.STRAIGHT);
    }

    @Test
    public void last_왼쪽() {
        assertThat(Direction.RIGHT.last()).isEqualTo(Direction.LEFT);
    }
}