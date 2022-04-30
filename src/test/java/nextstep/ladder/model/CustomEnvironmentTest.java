package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("사용자 정의 환경")
class CustomEnvironmentTest {

    @Test
    @DisplayName("참가자들과 결과들 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> CustomEnvironment.of(Participants.from(() -> Arrays.asList("a", "b")), Results.from(() -> Arrays.asList("100", "500"))));
    }

    @Test
    @DisplayName("참가자들과 결과들은 필수")
    void instance_nullArguments_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CustomEnvironment.of(Participants.from(() -> Arrays.asList("a", "b")), null));
        assertThatIllegalArgumentException().isThrownBy(() -> CustomEnvironment.of(null, Results.from(() -> Arrays.asList("100", "500"))));
    }

    @Test
    @DisplayName("참가자들과 결과들의 사이즈는 동일")
    void instance_differentSize_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> CustomEnvironment.of(Participants.from(() -> Arrays.asList("a", "b", "c")), Results.from(() -> Arrays.asList("100", "500"))));
    }
}
