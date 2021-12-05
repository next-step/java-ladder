package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("point의 size 값 맞는지 테스트")
    void drawSizeTest(int countOfPerson) {
        Line line = new Line(countOfPerson);
        assertThat(line.getPoints().get().size()).isEqualTo(countOfPerson);
    }
}