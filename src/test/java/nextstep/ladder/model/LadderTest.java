package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("사다리")
class LadderTest {

    private static final CustomEnvironment TWO_SIZE_ENVIRONMENT = CustomEnvironment.of(Participants.from(() -> Arrays.asList("a", "b")), Results.from(() -> Arrays.asList("100", "200")));
    private static final Lines TWO_HEIGHT_AND_POINTS_LINES = Lines.of(Positive.from(2), LineGenerator.of(Positive.from(2), Point::connected));

    @Test
    @DisplayName("사용자 환경과 라인들로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Ladder.of(TWO_SIZE_ENVIRONMENT, TWO_HEIGHT_AND_POINTS_LINES));
    }

    @Test
    @DisplayName("사용자 환경과 라인들은 필수")
    void instance_nullArguments_throwIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(null, TWO_HEIGHT_AND_POINTS_LINES));
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(TWO_SIZE_ENVIRONMENT, null));
    }

    @Test
    @DisplayName("사용자 환경과 라인 포인트의 사이즈는 반드시 동일")
    void instance_differentSize_throwIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.of(TWO_SIZE_ENVIRONMENT, Lines.of(Positive.from(2), LineGenerator.of(Positive.ONE, Point::connected))));
    }
}
