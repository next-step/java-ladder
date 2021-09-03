package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
    @Test
    @DisplayName("사다리 첫 번째 Line 의 다음 값이 true 이면 가로 라인이 겹치지 않게 두번째 Line의 다음 값은 false이다.   ")
    void init() {
        assertThat(Point.init(true).next(true).nextPoint()).isFalse();
        assertThat(Point.init(true).next(false).nextPoint()).isFalse();
    }

    @Test
    void next() {
        Point point = Point.init(true).next(); //
        assertThat(point).isEqualTo(Point.of(true, false));
    }

    @Test
    void move1() {
        Point first = Point.init(false); // (false , false)
        assertThat(first.move()).isEqualTo(0);
    }

    @Test
    void move2() {
        Point first = Point.init(true); // (false ,true)
        assertThat(first.move()).isEqualTo(1);
    }

    @Test
    void move3() {      // (false ,true)
        assertThat(Point.init(false).next(true).move()).isEqualTo(1);
    }

    @Test
    void move4() {  // (false , false)
        assertThat(Point.init(false).next(false).move()).isEqualTo(0);
    }

    @Test
    void move5() {  // (true , false)
        assertThat(Point.init(true).next(false).move()).isEqualTo(-1);
    }

    @Test
    void move6() { // (true, false) 이전 값이 true이면 다음 값은 무조건 false이다.
        assertThat(Point.init(true).next(true).move()).isEqualTo(-1);
    }
}
