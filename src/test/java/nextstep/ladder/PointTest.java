package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    @DisplayName("사다리 첫 번째 Line 의 다음 값이 true 이면 가로 라인이 겹치지 않게 두번째 Line의 다음 값은 false이다.   ")
    void init() {
        assertThat(Point.init(true).insert(true).nextPoint()).isFalse();
        assertThat(Point.init(true).insert(false).nextPoint()).isFalse();
    }

    @Test
    void insert() {
        Point first = Point.init(false); // (false , false)
        assertThat(first.move()).isEqualTo(0);
    }

    @Test
    void insert2() {
        Point first = Point.init(true); // (false ,true)
        assertThat(first.move()).isEqualTo(1);
    }

    @Test
    void insert3() {      // (false ,true)
        assertThat(Point.init(false).insert(true).move()).isEqualTo(1);
    }

    @Test
    void insert4() {  // (false , false)
        assertThat(Point.init(false).insert(false).move()).isEqualTo(0);
    }
    @Test
    void insert5() {  // (true , false)
        assertThat(Point.init(true).insert(false).move()).isEqualTo(-1);
    }

    @Test
    void insert6() { // (true, false) 이전 값이 true이면 다음 값은 무조건 false이다.
        assertThat(Point.init(true).insert(true).move()).isEqualTo(-1);
    }
}
