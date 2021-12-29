package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DirectionTest {

    @Test
    public void init() {
        assertEquals(Direction.of(true, false), Direction.of(true, false));
    }

    @Test
    @DisplayName("Direction 을 ture true 로 만들면 direction can't be (true, true) 를 반환")
    public void init_invalid() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(IllegalStateException.class).hasMessageContaining("direction can't be (true, true)");
    }

    @Test
    @DisplayName("첫번째 point 의 Direction 이 right 일 때 다음 point 의 Direction 은 true, false 가 반환")
    public void next_random_true() {
        Direction next = Direction.first(true).next();
        assertEquals(next, Direction.of(true, false));
    }

    @Test
    @DisplayName("첫번째 point 의 Direction 이 none 일 때 다음 point 의 Direction 은 right or none 가 반환")
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            assertThat(Direction.first(false), anyOf(is(Direction.of("left")), is(Direction.of("none"))));
        }
    }

    @Test
    @DisplayName("next method 의 인자로 true 를 넣어주면 Direction 이 false, true 인 Direction 반환 ")
    public void next_true() {
        Direction next = Direction.of(false, true).next(true);
        assertEquals(next, Direction.of(false, true));
    }

    @Test
    @DisplayName("next method 의 인자로 false 를 넣어주면 Direction 이 false, false 인 Direction 반환")
    public void next_false() {
        Direction next = Direction.of(false, false).next(false);
        assertEquals(next, Direction.of(false, false));
    }

    @Test
    @DisplayName("첫번째 Point 의 Direction 을 반환")
    public void first() {
        Direction first = Direction.first(true);
        assertEquals(first.isLeft(), false);
    }

    @Test
    @DisplayName("마지막 Point 의 Direction 을 반환")
    public void last() {
        Direction last = Direction.first(true).last();
        assertEquals(last, Direction.of(true, false));
    }
}
