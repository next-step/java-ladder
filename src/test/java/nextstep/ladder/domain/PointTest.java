package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

class PointTest {
    @DisplayName("처음 point 가 (right=true) 일 때 position 은 1 , false 면 0 이다.")
    @Test
    public void first() {
        assertThat(Point.first(TRUE).move(), is(1));
        assertThat(Point.first(FALSE).move(), is(0));
    }

    @DisplayName("처음에 (right=)false, 다음(index+1)도 (right=)false 면 index는 원래 자신의 인덱스와 같다.")
    @Test
    public void next_stay() {
        // first second
        //      |     |
        Point second = Point.first(FALSE).next(FALSE);
        assertThat(second.move(), is(1));
    }

    @DisplayName("두번째 Point 가 true, false 상태에 있으면 위치는 원래 위치의 -1 한 것과 같다.")
    @Test
    public void next_left() {
        // first second
        //      |-----|     |
        //second first
        Point second = Point.first(TRUE).next(FALSE);
        assertThat(second.move(), is(0));
    }

    @DisplayName("두번째 Point가 false, true 상태에 있으면 위치는 원래 위치의 +1 한 것과 같다.")
    @Test
    public void next_right() {
        // first second
        //      |     |-----|
        // first       second
        Point second = Point.first(FALSE).next(TRUE);
        assertThat(second.move(), is(2));
    }

    @DisplayName("두번째 Point가 true, 그리고 랜덤일 때 항상 false 가 와야 하므로 현재 위치의 -1한 것과 같다.")
    @Test
    public void next_random() {
        // first second
        //      |-----|    |
        //second first
        Point second = Point.first(TRUE).next(new RandomPointCreator());
        assertThat(second.move(), is(0));
    }
}