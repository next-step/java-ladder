package ladder.domain;

import ladder.domain.generator.StubBooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    private Lines lines;

    private final StubBooleanGenerator pointGenerator = new StubBooleanGenerator(true);
    private final int width = 4;
    private final int height = 5;

    @BeforeEach
    void setUp() {
        lines = new Lines(IntStream.range(0, height)
                                 .mapToObj(i -> Line.of(width, pointGenerator))
                                 .collect(Collectors.toList()));
    }

    @ParameterizedTest(name = "사다리 이동 검증. startPosition={0}, finishPosition={1}")
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,2",
            "3,3",
    })
    void move(int startPosition, int finishPosition) {

        assertThat(lines.move(startPosition)).isEqualTo(finishPosition);
    }

    @ParameterizedTest(name = "사다리 이동 시 시작위치가 유효하지 않다면 Exception 발생. startPosition={0}")
    @ValueSource(ints = {-1, 4})
    void moveException(int startPosition) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lines.move(startPosition));
    }
}