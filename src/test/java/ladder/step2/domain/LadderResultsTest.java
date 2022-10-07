package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultsTest {
    public static final LadderResults LADDER_RESULTS = new LadderResults("꽝, 5000, 꽝, notobook");
    
    @Test
    @DisplayName("사다리 실행 결과 생성")
    void create() {
        assertThat(LADDER_RESULTS).isNotNull();
    }
    
    @Test
    @DisplayName("쉼표 외의 구분자는 에러")
    void delimiter_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResults("꽝, 5000, 꽝. 3000"))
                .withMessage("올바른 입력 형식이 아닙니다. 다시 입력해주세요.");
    }
}