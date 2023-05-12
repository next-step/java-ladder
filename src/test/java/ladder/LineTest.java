package ladder;

import ladder.generator.RandomBooleanGenerator;
import ladder.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("라인의 Point 수는 참여자수와 일치한다.")
    @Test
    void lineSize() {
        Line line = Line.create(3, new RandomBooleanGenerator());
        assertThat(line.size()).isEqualTo(3);
    }
}
