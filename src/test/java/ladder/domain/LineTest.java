package ladder.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void lineCreateTest(int input) {
        CrossRoadStrategy crossRoadStrategy = () -> true;
        Line line = Line.of(input, crossRoadStrategy);

        IntStream.range(0, line.size())
                .boxed()
                .peek(i -> {
                    System.out.print(line.movable(i) + " ");
                })
                .filter(i -> i % 2 == 0)
                .forEach(i  -> {
                    boolean movable = line.movable(i);
                    assertThat(movable).isTrue();
                });
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
