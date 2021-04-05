package nextstep.ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatCode;

class RandomLineFactoryTest {

    @Test
    @DisplayName("라인에 연속된 연결 지점은 없어야 한다.")
    void shouldNotOverlapPointsThatConsistOfLine() {
        LineFactory lineFactory = new RandomLineFactory();

        for (int i = 0; i < 1000; ++i) {
            IntStream.rangeClosed(2, 100)
                     .forEach(numberOfPoints ->
                         assertThatCode(() -> lineFactory.createLine(numberOfPoints)).doesNotThrowAnyException());
        }
    }
}
