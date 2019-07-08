package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리의 높이 입력란에 숫자가 아닌 문자가 포함 되어 있을 경우 오류 테스트")
    void ladderHeightValidation() {
        Assertions.assertThatThrownBy(() -> new Ladder(4, "다섯"))
                  .isInstanceOf(NumberFormatException.class)
                  .hasMessage("최대 사다리 높이는 숫자만 입력 할 수 있습니다.");
    }

}
