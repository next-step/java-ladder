package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("Result 객체 생성 및 값 확인")
    void createResult() {
        // given
        String value = "5000";

        // when
        Result result = new Result(value);

        // then
        assertThat(result.getResult()).isEqualTo("5000");
    }

    @Test
    @DisplayName("빈 문자열로 Result 생성 시 예외 발생")
    void createResultWithEmptyString() {
        assertThatThrownBy(() -> new Result(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과는 빈 값일 수 없습니다");
    }

    @Test
    @DisplayName("공백으로 Result 생성 시 예외 발생")
    void createResultWithOnlyWhiteSpaceString() {
        assertThatThrownBy(() -> new Result(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과는 빈 값일 수 없습니다");
    }

    @Test
    @DisplayName("null로 Result 생성 시 예외 발생")
    void createResultWithNull() {
        assertThatThrownBy(() -> new Result(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과는 빈 값일 수 없습니다");
    }
}
