package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultTest {
    public static final LadderResult LADDER_RESULT = new LadderResult("3000");
    
    @Test
    @DisplayName("사다리 실행 결과 단일 객체 생성")
    void create() {
        assertThat(LADDER_RESULT).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 실행 결과 단일 데이터 가져오기")
    void get_ladder_result() {
        assertThat(LADDER_RESULT.getLadderResult()).isEqualTo("3000");
    }
    
    @Test
    @DisplayName("실행 결과 길이가 7자를 초과한 경우 예외")
    void ladder_result_length_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LadderResult("12345678"))
                .withMessage("하나의 실행 결과의 문자 길이는 7자를 초과할 수 없습니다. 다시 입력해주세요.");
    }
}