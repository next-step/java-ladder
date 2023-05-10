package ladder;

import ladder.model.Line;
import ladder.generator.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {
    @DisplayName("라인의 길이는 사람 수 보다 하나 적다")
    @Test
    void lineSize() {
        Line line = Line.of(3, new RandomBooleanGenerator());
        assertThat(line.size()).isEqualTo(2);
    }

    @DisplayName("이전 위치의 값과 동일한 값을 가질 수 없다")
    @Test
    void lineCreate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(List.of(true, true, true)));
    }
}
