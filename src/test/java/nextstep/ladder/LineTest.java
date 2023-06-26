package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인 만들기")
    public void newLinet() {
        Line line = new Line(4);
        assertThat(line.getShape()).hasSize(24);

    }
}
