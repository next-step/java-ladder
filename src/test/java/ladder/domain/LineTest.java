package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("creatingStrategy 인터페이스로 의도한 값을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false", "2:true", "3:false", "4:true"}, delimiter = ':')
    void createPoint(int index, boolean point) {
        Line line = new Line(() -> true, 5);

        assertThat(line.getPoints()).hasSize(5);
        assertThat(line.getPoints().get(index)).isEqualTo(point);
    }

    @Test
    @DisplayName("라인을 그린다.")
    void drawLine() {
        Line line = new Line(() -> true, 2);
        String lineFormat = line.drawLine();

        assertThat(lineFormat).isEqualTo("|-----|     |");
    }
}
