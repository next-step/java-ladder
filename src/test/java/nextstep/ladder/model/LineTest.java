package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @Test
    @DisplayName("두 Line의 동일한 index는 둘 다 True일 수 없다.")
    void test1() {
        //given
        Line lineA = new Line(List.of(false, true, true, false, false));
        Line lineB = lineA.generateLine();
        //then
        assertThat(lineA.point(1)).isNotEqualTo(lineB.point(1));
        assertThat(lineA.point(2)).isNotEqualTo(lineB.point(2));
    }
}