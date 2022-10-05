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
}