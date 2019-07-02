package ladder.domain;

import ladder.domain.generator.StubPointGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LinesTest {

    @Test
    @DisplayName("of 메소드 객체생성 확인")
    void of() {

        // given
        StubPointGenerator pointGenerator = new StubPointGenerator(true);
        int width = 4;
        int height = 5;
        Lines lines = Lines.of(width, height, pointGenerator);

        // when
        Lines expected = Lines.of(
                IntStream.range(0, height)
                        .mapToObj(i -> Line.of(width, pointGenerator))
                        .collect(Collectors.toList()));

        // then
        assertThat(lines).isEqualTo(expected);
    }

    @ParameterizedTest(name = "사다리 이동 검증. startPosition={0}, finishPosition={1}")
    @CsvSource(value = {
            "0,1",
            "1,0",
            "2,2",
            "3,3",
    })
    void move(int startPosition, int finishPosition) {

        StubPointGenerator pointGenerator = new StubPointGenerator(true);
        int width = 4;
        int height = 5;
        Lines lines = Lines.of(width, height, pointGenerator);

        assertThat(lines.move(startPosition)).isEqualTo(finishPosition);
    }

    @ParameterizedTest(name = "사다리 이동 시 시작위치가 유효하지 않다면 Exception 발생. startPosition={0}")
    @ValueSource(ints = {-1, 4})
    void moveException(int startPosition) {

        StubPointGenerator pointGenerator = new StubPointGenerator(true);
        int width = 4;
        int height = 5;
        Lines lines = Lines.of(width, height, pointGenerator);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lines.move(startPosition));
    }
}