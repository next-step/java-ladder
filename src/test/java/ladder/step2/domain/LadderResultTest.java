package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}