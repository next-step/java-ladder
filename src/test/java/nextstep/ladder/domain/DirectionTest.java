package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DirectionTest {

    @DisplayName("왼쪽 방향만 true 일때, 같은 Direction 이다.")
    @Test
    public void init() {
        assertThat(Direction.of(true, false), is(Direction.of(true, false)));
        assertThat(Direction.of(false, true), is(Direction.of(false, true)));
    }

    @DisplayName("둘 다 true 인 Direction 이 생길 수 없다.")
    @Test
    public void init_invalid() {
        assertThrows(IllegalStateException.class, () -> {
            Direction.of(TRUE, TRUE);
        });
    }

    @DisplayName("true(right)의 다음은 무조건 false(right) 여야 한다.")
    @Test
    public void next_random_true() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @DisplayName("false 다음으로는 랜덤으로 true, false 가 올 수 있다. ")
    @Test
    public void next_random_false() {
        Direction next = Direction.first(FALSE).next();
        Assertions.assertThat(next.isRight()).isIn(Arrays.asList(false, true));
    }

    @DisplayName(" 이전이 true 고(left = true, right = false) 이고, " +
            "다음에 right 가 true 면 left= false, right=true Direction 과 같다.")
    @Test
    public void next_true() {
        // -----|     |----- (next)
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next, is(Direction.of(FALSE, TRUE)));
    }

    @DisplayName("left = false, right = true 인 Direction 의 left = true, right = false 와 같다. ")
    @Test
    public void next_false() {
        // |     |-----| (next)
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next, is(Direction.of(TRUE, FALSE)));
    }

    @DisplayName("처음 player 의 left 는 항상 false 다.")
    @Test
    public void first() {
        // first
        //     |-----
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @DisplayName("마지막 player 의 right 은 항상 false 다.")
    @Test
    public void last() {
        //   last
        // -----|
        Direction last = Direction.first(TRUE).last();
        assertThat(last, is(Direction.of(TRUE, FALSE)));
    }
}