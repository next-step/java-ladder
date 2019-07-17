package ladder.domain;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("초기화_함수")
    public void init() {
        assertThat(Direction.of(true, false), is(Direction.of(true, false)));
    }

    @Test(expected = IllegalStateException.class)
    @DisplayName("초기화_함수_유효성_체크")
    public void init_invalid() {
        Direction.of(TRUE, TRUE);
    }

    @Test
    @DisplayName("next함수 : left값이 TRUE이면, right 값은 반드시 FALSE으로 생성")
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    @DisplayName("next함수 : left값이 FALSE이면, right 값은 random 값으로 생성")
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            Direction.first(FALSE).next();
        }
    }

    @Test
    @DisplayName("next함수 : right값이 TRUE값이 되도록 생성")
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next, is(Direction.of(FALSE, TRUE)));
    }

    @Test
    @DisplayName("next함수 : right값이 FALSE값이 되도록 생성")
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @Test
    @DisplayName("first함수 : 첫 left값은 FALSE으로 설정")
    public void first() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @Test
    @DisplayName("last함수 : 마지막 right값은 FALSE으로 설정")
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last, is(Direction.of(TRUE, FALSE)));
    }
}