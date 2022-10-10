package ladder.step2.dto;

import ladder.step2.domain.LadderResultsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultsDTOTest {
    public static final LadderResultsDTO LADDER_RESULTS_DTO = new LadderResultsDTO(LadderResultsTest.LADDER_RESULTS);
    
    @Test
    @DisplayName("사다리 실행 결과 생성")
    void create() {
        assertThat(LADDER_RESULTS_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 실행 결과 가져오기")
    void get_ladder_results() {
        assertThat(LADDER_RESULTS_DTO.getLadderResultsDTOS()).isNotNull();
    }
}
