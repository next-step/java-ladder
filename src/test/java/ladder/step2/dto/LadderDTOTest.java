package ladder.step2.dto;

import ladder.step2fixture.dto.LadderDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDTOTest {
    @Test
    @DisplayName("LadderDTO 생성")
    void create() {
        assertThat(LadderDTOFixture.LADDER_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("LadderDTO 데이터 있는지 확인")
    void is_exist_data() {
        assertThat(LadderDTOFixture.LADDER_DTO.getLines()).isNotNull();
    }
}