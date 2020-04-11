package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("연결여부를 알고있는 라인을 생성할 수 있다")
    @Test
    public void newLineTest() {
        Line line = new Line(3, false);
        Line anotherLine = new Line(3, false);

        assertThat(line).isEqualTo(anotherLine);
    }

    @DisplayName("같은 높이의 이전 라인이 열결되어 있으면 현재 라인은 연결 될 수 없다")
    @Test
    public void newLineOnConditionOfBeforeLine() {
        Line beforeLine = new Line(1, true);

        Line nowLine = Line.newLineOnBeforeLine(beforeLine);
        Line expected = new Line(1, false);

        assertThat(nowLine).isEqualTo(expected);
    }

}
