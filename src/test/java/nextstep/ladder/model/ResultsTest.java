package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("결과들")
class ResultsTest {

    @Test
    @DisplayName("문자열들 제공자로 결과들 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Results.from(() -> Arrays.asList("a", "b")));
    }

    @Test
    @DisplayName("문자열들 제공자는 필수")
    void instance_nullStringsProvider_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Results.from(null));
    }

    @Test
    @DisplayName("결과는 2개 이상")
    void instance_lessThanTwo_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Results.from(() -> Collections.singletonList("a")));
    }

    @Test
    @DisplayName("사이즈 2만큼 미소유 여부")
    void hasNotSize() {
        //given
        Results twoResults = Results.from(() -> Arrays.asList("a", "b"));
        //when, then
        assertThat(twoResults.hasNotSize(2)).isFalse();
        assertThat(twoResults.hasNotSize(3)).isTrue();
    }
}
