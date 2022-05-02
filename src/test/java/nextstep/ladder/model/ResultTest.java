package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("결과")
class ResultTest {

    @Test
    @DisplayName("문자열로 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Result.from("result"));
    }

    @ParameterizedTest(name = "[{index}] {0} 값으로 이름 생성 불가")
    @DisplayName("문자열은 필수")
    @NullAndEmptySource
    void instance_nullOrEmpty_thrownIllegalArgumentException(String result) {
        assertThatIllegalArgumentException().isThrownBy(() -> Result.from(result));
    }

    @Test
    @DisplayName("주어진 이름 그대로 반환")
    void value() {
        //given
        String result = "a";
        //when, then
        assertThat(Result.from(result).value()).isEqualTo(result);
    }

}
