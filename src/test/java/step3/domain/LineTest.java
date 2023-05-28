package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @DisplayName("사람의 수만큼 Horizontal Line을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    public void generateLineTest(int countOfPerson) {
        assertThat(new Line(countOfPerson).getPoints()).hasSize(countOfPerson - 1);
    }

    @DisplayName("연속적인 가로줄은 있을 수 없다.")
    @Test
    public void shouldNotGenerateHorizontal() {
        assertThatThrownBy(() -> new Line(5, count -> List.of(true, true, true, false)))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("사다리타기 - 다음 라인으로 이동")
    @ParameterizedTest
    @MethodSource("testMoveLineTestCase")
    public void testMoveLine(Line line, Map<Integer, Integer> resultMap) {
        resultMap.keySet()
                .forEach(
                        key -> assertThat(line.nextIndex(key))
                                .isEqualTo(resultMap.get(key)));
    }

    static Stream<Arguments> testMoveLineTestCase() {
        return Stream.of(
                Arguments.arguments(
                        new Line(4, count -> List.of(false, false, false)),
                        Map.of(0, 0, 1, 1, 2, 2, 3, 3)),
                Arguments.arguments(
                        new Line(4, count -> List.of(true, false, true)),
                        Map.of(0, 1, 1, 0, 2, 3, 3, 2)),
                Arguments.arguments(
                        new Line(4, count -> List.of(false, true, false)),
                        Map.of(0, 0, 1, 2, 2, 1, 3, 3))
        );
    }
}
