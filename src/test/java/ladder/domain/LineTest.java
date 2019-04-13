package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static ladder.domain.Fixture.CONNECTED_LINE;
import static ladder.domain.Fixture.DISCONNECTED_LINE;

public class LineTest {

    @Test
    public void 라인그리기_테스트() {
        Line result = CONNECTED_LINE;
        Assertions.assertThat(result).isEqualTo(CONNECTED_LINE);
        Assertions.assertThat(result.getPoints().size()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 라인그리기_실패_테스트() {
        new Line(1, Level.LOW);
    }

    @Test
    public void 오른쪽_이동테스트() {
        Line result = CONNECTED_LINE;
        int movedResult = result.movePoint(0);
        Assertions.assertThat(movedResult).isEqualTo(1);
    }

    @Test
    public void 왼쪽_이동테스트() {
        Line result = CONNECTED_LINE;
        int movedResult = result.movePoint(1);
        Assertions.assertThat(movedResult).isEqualTo(0);
    }

    @Test
    public void 이동테스트_안함() {
        Line result = DISCONNECTED_LINE;
        int movedResult = result.movePoint(0);
        Assertions.assertThat(movedResult).isEqualTo(0);
    }
}