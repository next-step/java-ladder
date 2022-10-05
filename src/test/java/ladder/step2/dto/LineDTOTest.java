package ladder.step2.dto;

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
}