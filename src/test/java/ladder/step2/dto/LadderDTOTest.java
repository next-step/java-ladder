package ladder.step2.dto;

import ladder.step2.domain.LadderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDTOTest {
    public static final LadderDTO LADDER_DTO = new LadderDTO(LadderTest.LADDER.ladderInformation().getLines());
    
    @Test
    @DisplayName("LadderDTO 생성")
    void create() {
        assertThat(LadderDTOTest.LADDER_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("LadderDTO 데이터 있는지 확인")
    void is_exist_data() {
        assertThat(LadderDTOTest.LADDER_DTO.getLines()).isNotNull();
    }
}