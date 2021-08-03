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

        // when
        boolean exists = new DefaultLineExistsGenerator().generate(true);

        // then
        assertThat(exists).isFalse();


    }

    @DisplayName("[성공] 생성 - prevFalse")
    @Test
    public void generator_prevFalse() {
        // given

        // when
        Stream<Boolean> currentStream = Stream.generate(() -> new DefaultLineExistsGenerator().generate(false))
            .limit(100);

        // then
        assertThat(currentStream.anyMatch(c -> !c)).isTrue();
    }
}
