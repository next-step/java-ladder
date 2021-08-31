package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.util.RandomUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("참여자의 수에 맞는 사다리 라인 생성")
    void create() {
        assertThat(new Line(5).size()).isEqualTo(5);
    }

    @Test
    @DisplayName("현재 point 가 true이면 다음 point는 무조건 false가 와야 한다. 즉 ,(true, false)")
    void checkPreviousPoint() {
        Line point = new Line();
        assertThat(point.checkPreviousPoint(true)).isEqualTo(Point.of());
    }

    @Test
    @DisplayName("현재 point 가 false이면 다음 point는 랜덤값을 넣는다. 즉 ,(true, 랜덤)")
    void checkPreviousPoint2() {
        Line point = new Line();
        assertThat(point.checkPreviousPoint(false)).isEqualTo(Point.of(RandomUtil.generate()));
    }
}