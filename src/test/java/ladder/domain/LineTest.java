package ladder.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class LineTest {

    @DisplayName("사다리 생성시 룰이 True 인경우 짝수번째만 항상 TRUE")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10000, 10001})
    void lineCreateTest(int input) {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Line line = Line.of(input, crossRoadStrategy);

        LineParityCheck isOdd = i -> i % 2 == 1;
        filter(line, isOdd).forEach(i -> assertThat(line.movable(i)).isFalse());

        LineParityCheck isEven = i -> i % 2 == 0;
        filter(line, isEven).forEach(i -> assertThat(line.movable(i)).isTrue());
    }

    private Stream<Integer> filter(Line line, LineParityCheck parityCheck) {
        return IntStream.range(0, line.size())
                .boxed()
                .filter(parityCheck::parityCheck);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 1:-1", "3 2:0", "4 2:1"}, delimiter = ':')
    void steerWayTest(String input, String expected) {
        String[] inputs = input.split(" ");
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Line line = Line.of(Integer.parseInt(inputs[0]), crossRoadStrategy);

        SteerRule steerRule = line.steerWay(Integer.parseInt(inputs[1]));

        assertThat(steerRule.getSteer()).isEqualTo(Integer.parseInt(expected));
    }
}
