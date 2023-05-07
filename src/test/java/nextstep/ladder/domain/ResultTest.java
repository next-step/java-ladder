package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("결과 객체 생성 테스트")
    void resultCreateTest(int input) {
        Result result = new Result(input);

        assertThat(result.getResult())
                .isEqualTo(input);
    }

    @Test
    @DisplayName("마이너스 값일 경우 에러 발생")
    void minusErrorTest() {
        assertThatThrownBy(() -> new Result(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
