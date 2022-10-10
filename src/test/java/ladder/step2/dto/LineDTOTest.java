package ladder.step2.dto;

import ladder.step2.domain.LineTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineDTOTest {
    public static final LineDTO LINE_DTO = new LineDTO(LineTest.LINE);
    
    @Test
    @DisplayName("LineDTO 생성")
    void create() {
        assertThat(LINE_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("LineDTO 데이터 가져오기")
    void is_exist_data() {
        assertThat(LINE_DTO.getPartLines()).isNotNull();
    }
}