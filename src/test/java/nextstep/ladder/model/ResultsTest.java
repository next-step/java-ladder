package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("결과들")
class ResultsTest {

    @Test
    @DisplayName("문자열들로 결과들 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Results.from(Arrays.asList("a", "b")));
    }

    @Test
    @DisplayName("문자열들은 필수")
    void instance_nullStringsProvider_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Results.from(null));
    }

    @Test
    @DisplayName("결과는 2개 이상")
    void instance_lessThanTwo_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Results.from(Collections.singletonList("a")));
    }

    @Test
    @DisplayName("사이즈 2만큼 미소유 여부")
    void hasDifferentSize() {
        //given
        Results twoResults = Results.from(Arrays.asList("a", "b"));
        //when, then
        assertThat(twoResults.hasDifferentSize(2)).isFalse();
        assertThat(twoResults.hasDifferentSize(3)).isTrue();
    }

    @Test
    @DisplayName("인데스 위치로 결과 가져오기")
    void result() {
        //given
        Results twoResults = Results.from(Arrays.asList("a", "b"));
        //when, then
        assertThat(twoResults.result(0)).isEqualTo(Result.from("a"));
    }

    @Test
    @DisplayName("인데스 위치로 결과 가져오기")
    void result_invalidIndex_thrownIndexOutOfBoundsException() {
        //given
        Results twoResults = Results.from(Arrays.asList("a", "b"));
        //when, then
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> twoResults.result(Integer.MIN_VALUE));
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> twoResults.result(Integer.MAX_VALUE));
    }

    @Test
    @DisplayName("주어진 문자열대로 리스트 반환")
    void list() {
        assertThat(Results.from(Arrays.asList("a", "b")).list()).containsExactly(Result.from("a"), Result.from("b"));
    }
}
