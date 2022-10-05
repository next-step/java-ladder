package ladder.step2.dto;

import ladder.step2fixture.dto.LadderDTOFixture;
import ladder.step2fixture.dto.LineDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineDTOTest {
    @Test
    @DisplayName("LineDTO 생성")
    void create() {
        assertThat(LineDTOFixture.LINE_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("LineDTO 데이터 있는지 확인")
    void is_exist_data() {
        assertThat(LineDTOFixture.LINE_DTO.getPartLines()).isNotNull();
    }
}