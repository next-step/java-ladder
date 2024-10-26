package nextstep.ladder.domain.direction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLineGeneratorTest {

    @Test
    void doNotGenerateTrueFromTrue() {
        IntStream.range(0, 100).parallel().forEach(i ->
                assertThat(RandomLineGenerator.getInstance().generate(true)).isFalse()
        );
    }

    @Test
    @DisplayName("확률적으로 시도 횟수가 클 때 참과 거짓은 최소한 한번은 생성되어야 한다")
    void shouldTrueAndFalseAppearAtLeastOnceStatistically() {
        List<Boolean> randomGenerated = IntStream.range(0, 1000).
                parallel()
                .mapToObj(i -> RandomLineGenerator.getInstance().generate(false))
                .collect(Collectors.toList());

        assertThat(randomGenerated).contains(true, false);
    }
}
