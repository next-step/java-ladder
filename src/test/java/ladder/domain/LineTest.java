package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @DisplayName("입력한 width 의 개수만큼의 Point list 생성")
    void createLineTest(int width) {
        Line of = Line.of(width, () -> true);
        assertThat(of.getPoints()).hasSize(width);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiter = ':')
    @DisplayName("라인에서 포인트 값에 따라서 인덱스의 좌우 이동을 확인한다")
    void move(int currentIndex, int expectedIndex) {
        Line line = Line.create(List.of(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false)));

        assertThat(line.move(currentIndex)).isEqualTo(expectedIndex);
    }
}