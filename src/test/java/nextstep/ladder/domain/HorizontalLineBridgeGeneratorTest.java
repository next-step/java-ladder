package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("가로줄 여부 생성기")
class HorizontalLineBridgeGeneratorTest {

    @DisplayName("[성공] 생성 - prevTrue")
    @Test
    public void generator_prevTrue() {
        // given

        // when
        final boolean bridge = new DefaultLineBridgeGenerator().generate(true);

        // then
        assertThat(bridge).isFalse();


    }

    @DisplayName("[성공] 생성 - prevFalse")
    @Test
    public void generator_prevFalse() {
        // given

        // when
        final Stream<Boolean> currentStream = Stream.generate(() -> new DefaultLineBridgeGenerator().generate(false))
            .limit(100);

        // then
        assertThat(currentStream.anyMatch(c -> !c)).isTrue();
    }
}
