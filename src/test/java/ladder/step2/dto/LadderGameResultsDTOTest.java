package ladder.step2.dto;

import ladder.step2.domain.LadderGameResultsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultsDTOTest {
    public static final LadderGameResultsDTO LADDER_GAME_RESULTS_DTO = new LadderGameResultsDTO(LadderGameResultsTest.LADDER_GAME_RESULTS);
    
    @Test
    @DisplayName("최종 결과 DTO 생성")
    void create() {
        assertThat(LADDER_GAME_RESULTS_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("최종 결과 가져오기")
    void get_ladder_game_results() {
        assertThat(LADDER_GAME_RESULTS_DTO.getLadderGameResults()).isEqualTo(LadderGameResultsTest.LADDER_GAME_RESULTS.getLadderGameResults());
    }
}