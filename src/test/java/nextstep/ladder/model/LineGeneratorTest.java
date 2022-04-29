package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("라인 생성기")
class LineGeneratorTest {

    @Test
    @DisplayName("참여자 수와 포인트 생성기로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> LineGenerator.of(Positive.ONE, Point::connected));
    }

    @Test
    @DisplayName("참여자 수와 포인트 생성기는 필수")
    void instance_nullArguments_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LineGenerator.of(Positive.ONE, null));
        assertThatIllegalArgumentException().isThrownBy(() -> LineGenerator.of(null, Point::connected));
    }

    @Test
    @DisplayName("사다리 라인 생성")
    void line() {
        assertThat(LineGenerator.of(Positive.from(2), Point::disconnected).line()).isNotNull();
    }
}
