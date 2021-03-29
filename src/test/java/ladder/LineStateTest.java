package ladder;

import ladder.domain.Line;
import ladder.domain.LineState;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineStateTest {

    @Test
    @DisplayName("라인의 상태를 알 수 있다.")
    void canKnowLineState() {
        int countOfPerson = 2;
        Line line = new Line(countOfPerson);

        line.getPoints().add(0, true);
        line.getPoints().add(1, false);

        Assertions.assertThat(LineState.state(line.getPoints().get(0))).isEqualTo("-----");
    }
}
