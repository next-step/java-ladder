package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("Line을 생성 할 수 있다")
    @Test
    void line() {
        // Given
        Line line = Line.of(3);

        // When && Then
        assertThat(line.size()).isEqualTo(3);
    }

    @DisplayName("이어지는 라인이 없어야한다")
    @Test
    void lineWithValidation() {
        // Given
        Line line = Line.of(3);
        List<Boolean> lines = line.getPoints();

        // When
        Boolean prev = lines.get(0);

        // Then
        for (int i = 1; i < lines.size(); i++) {
            Boolean curr = lines.get(i);

            if (prev) {
                assertThat(curr).isFalse();
            }

            prev = curr;
        }
    }


}
