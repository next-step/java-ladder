package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    @Test
    public void 왼쪽() {
        Direction left = Direction.of(true, false);

        assertThat(left).isSameAs(Direction.LEFT);
        assertThat(left.isLeft()).isTrue();
        assertThat(left.isRight()).isFalse();
    }

    @Test
    public void 패스() {
        Direction pass = Direction.of(false, false);

        assertThat(pass).isSameAs(Direction.PASS);
        assertThat(pass.isLeft()).isFalse();
        assertThat(pass.isRight()).isFalse();
    }

    @Test
    public void 오른쪽() {
        Direction rigth = Direction.of(false, true);

        assertThat(rigth).isSameAs(Direction.RIGHT);
        assertThat(rigth.isLeft()).isFalse();
        assertThat(rigth.isRight()).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 없는_방향() {

        Direction.of(true, true);
    }

    @Test
    public void first_true() {
        Direction first = Direction.first(true);

        assertThat(first).isSameAs(Direction.RIGHT);
    }

    @Test
    public void first_false() {
        Direction first = Direction.first(false);

        assertThat(first).isSameAs(Direction.PASS);
    }

    @Test
    public void next_false() {
        Direction pass = Direction.PASS;

        Direction next = pass.next(false);

        assertThat(next).isSameAs(Direction.PASS);
    }

    @Test
    public void next_true() {
        Direction pass = Direction.PASS;

        Direction next = pass.next(true);

        assertThat(next).isSameAs(Direction.RIGHT);
    }

    @Test
    public void last() {
        Direction left = Direction.LEFT;
        Direction right = Direction.RIGHT;
        Direction pass = Direction.PASS;

        Direction leftLast = left.last();
        Direction rightLast = right.last();
        Direction passLast = pass.last();

        assertThat(leftLast.isRight()).isFalse();
        assertThat(rightLast.isRight()).isFalse();
        assertThat(passLast.isRight()).isFalse();
    }

}