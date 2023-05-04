package nextstep.ladder.domain;

import nextstep.ladder.support.TestRandomBoolean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인의 개수는 (사람 수 - 1) 이다")
    void test01() {
        TestRandomBoolean randomBoolean = new TestRandomBoolean(new LinkedList<>(List.of(true, false, false, true)));

        Line line = new Line(5, randomBoolean);

        assertThat(line.points()).hasSize(4);
        assertThat(line.points()).containsExactly(true, false, false, true);
    }

    @Test
    @DisplayName("0번째 Point 는 원하는 값을 갖는다.")
    void test02() {
        Line line = new Line(true, false, false);

        assertThat(line.points()).containsExactly(true, false, false);
    }

    @Test
    @DisplayName("이전 Point 가 true 면 다음 Point 는 false 이다.")
    void test03() {
        Line line = new Line(false, true, true);

        assertThat(line.points()).containsExactly(false, true, false);
    }
}
