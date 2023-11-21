package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ResultTest {

    @Test
    @DisplayName("5글자 이하의 정상적인 결과를 입력시 결과는 정상 생성된다.")
    void createResult() {
        Result result = new Result("당첨");

        assertThat(result).isEqualTo(new Result("당첨"));
    }

    @Test
    @DisplayName("5글자를 초과하는 결과를 입력시 결과 생성에 실패한다")
    void createResult_5글자초과() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Result("여섯자리결과"))
                .withMessage("결과는 5글자 이상 입력할 수 없습니다.");
    }
}