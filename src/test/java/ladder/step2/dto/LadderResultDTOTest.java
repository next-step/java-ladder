package ladder.step2.dto;

import ladder.step2.domain.LadderResultTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultDTOTest {
    public static final LadderResultDTO LADDER_RESULT_DTO = new LadderResultDTO(LadderResultTest.LADDER_RESULT);
    
    @Test
    @DisplayName("사다리 단일 실행 결과 생성")
    void create() {
        assertThat(LADDER_RESULT_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 단일 실행 결과 생성")
    void get_ladder_result() {
        assertThat(LADDER_RESULT_DTO.getLadderResult()).isEqualTo("3000");
    }
}