package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("입력된 숫자 만큼 라인이 생성 된다")
    void newLine1() {
        Line actual = new Line(2);
        Line expected = new Line(List.of(Boolean.FALSE, Boolean.FALSE));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이전 위치에 가로선이 있을 경우 그릴 수 없다")
    void newLine2() {
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("다음 위치에 가로선이 있을 경우 그릴 수 없다")
    void newLine3() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("이전과 다음 위치에 가로선이 없을 경우 그릴 수 있다")
    void newLine4() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        boolean actual = line.canDraw(1);

        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("라인을 그릴 수 있다")
    void draw() {
        Line actual = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        actual.draw(1, true);
        Line expected = new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("오른쪽으로 이동을 한다")
    void calculatePoint1() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
        Direction actual = line.nextDirection(1);
        Direction expected = Direction.RIGHT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽으로 이동을 한다")
    void calculatePoint2() {
        Line line = new Line(List.of(Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
        Direction actual = line.nextDirection(1);
        Direction expected = Direction.LEFT;

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동하지 않는다")
    void calculatePoint3() {
        Line line = new Line(List.of(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE));
        Direction actual = line.nextDirection(1);
        Direction expected = Direction.STAY;

        assertThat(actual).isEqualTo(expected);
    }
}
