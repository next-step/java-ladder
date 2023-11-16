package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 입력된_숫자_만큼_라인이_생성_된다() {
        Line actual = new Line(2);
        Line expected = new Line(List.of(Boolean.FALSE, Boolean.FALSE));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이전_위치에_가로선이_있을_경우_그릴_수_없다() {
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isFalse();
    }

    @Test
    void 다음_위치에_가로선이_있을_경우_그릴_수_없다() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isFalse();
    }

    @Test
    void 이전과_다음_위치에_가로선이_없을_경우_그릴_수_있다() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isTrue();
    }

    @Test
    void 라인을_그릴_수_있다() {
        Line actual = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        actual.draw(1, true);
        Line expected = new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("오른쪽으로 이동을 한다")
    void calculatePoint1() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
        int actual = line.calculatePoint(1);
        int expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동을 한다")
    void calculatePoint2() {
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        int actual = line.calculatePoint(1);
        int expected = -1;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동하지 않는다")
    void calculatePoint3() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        int actual = line.calculatePoint(1);
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }
}
