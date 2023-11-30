package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void 라인_생성() {
        int countOfPerson = 3;
        Line line = new Line(countOfPerson);
        String error = "true, true";

        assertThat(line.toString().contains(error)).isFalse();
    }
}