package ladder.domain;


import org.junit.jupiter.params.ParameterizedTest;
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
}
