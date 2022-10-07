package ladder.step2.dto;

import ladder.step2.domain.LadderTest;
import ladder.step2.domain.LineTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDTOTest {
    public static final LadderDTO LADDER_DTO = new LadderDTO(LadderTest.LADDER);
    
    @Test
    @DisplayName("LadderDTO 생성")
    void create() {
        assertThat(LadderDTOTest.LADDER_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("LadderDTO 데이터 가져오기")
    void get_line_dtos() {
        assertThat(LadderDTOTest.LADDER_DTO.getLineDTOS()).isNotNull();
    }
}