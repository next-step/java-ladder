package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가로줄 여부 생성기")
class LineExistsGeneratorTest {

    @DisplayName("[성공] 생성 - prevTrue")
    @Test
    public void generator_prevTrue() {
        // given
        boolean prev = true;

        // when
        boolean exists = LineExistsGenerator.generate(prev);
        int asdf = 1;

        // then
        assertThat(exists).isFalse();


    }

    @DisplayName("[성공] 생성 - prevFalse")
    @Test
    public void generator_prevFalse() {
        // given
        boolean prev = false;

        // when
        Stream<Boolean> currentStream = Stream.generate(() -> LineExistsGenerator.generate(prev))
            .limit(100);

        // then
        assertThat(currentStream.anyMatch(c -> !c)).isTrue();
    }
}
