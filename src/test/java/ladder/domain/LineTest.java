package ladder.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.exception.LineInvalidException;
import ladder.strategy.LineCreationStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    @DisplayName("Line 생성 시 countOfPersons - 1 크기의 리스트가 생성되는지 확인")
    void testConstructor() {
        Line line = new Line(5);

        assertThat(line.getPoints()).isNotNull();
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("Line 생성 시 validation 이 정상적으로 작동하는지 확인")
    void testValidatePoints() {
        LineCreationStrategy strategy = countOfPersons -> List.of(true, false, true, true);
        assertThrows(LineInvalidException.class, () -> new Line(5, strategy));
    }


}
