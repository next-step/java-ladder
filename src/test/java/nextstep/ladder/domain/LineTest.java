package nextstep.ladder.domain;

import nextstep.ladder.support.TestRandomBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인은 포인트를 가지고 있다.")
    void test01() {
        TestRandomBoolean randomBoolean = new TestRandomBoolean(new LinkedList<>(List.of(true, false)));

        Line line = new Line(3, randomBoolean);

        assertThat(line.points()).hasSize(3);
        assertThat(line.points()).containsExactly(new Point(false, true),
                                                  new Point(true, false),
                                                  new Point(false, false));
    }

    @Test
    @DisplayName("0번째 Point 는 원하는 값을 갖는다.")
    void test02() {
        Line line = new Line(true, false, false);

        assertThat(line.points()).containsExactly(new Point(false, true),
                                                  new Point(true, false),
                                                  new Point(false, false));
    }

    @Test
    @DisplayName("이전 Point 가 true 면 다음 Point 는 false 이다.")
    void test03() {
        Line line = new Line(false, true, true);

        assertThat(line.points()).containsExactly(new Point(false, false),
                                                  new Point(false, true),
                                                  new Point(true, false));
    }

    @Test
    @DisplayName("라인에서 이전 포지션에 선이 있으면 현재 포지션에서 1 증가한다.")
    void test04() {
        Line line = new Line(false, true, false);

        assertThat(line.position(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("라인에서 다음 포인트에 선이 있으면 현재 포지션에서 1 증가한다.")
    void test05() {
        Line line = new Line(true, false, false);

        assertThat(line.position(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("라인에서 다음 포인트에 선이 있으면 현재 포지션에서 1 감소한다.")
    void test06() {
        Line line = new Line(false, false, true);

        assertThat(line.position(0)).isEqualTo(0);
    }
}
