package ladder.step2.domain.dto;

import ladder.step2.domain.LadderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDTOTest {
    public static final LadderDTO LADDER_DTO = new LadderDTO(LadderTest.LADDER.ladderInformation().getLines());
    
    @Test
    @DisplayName("LadderDTO 생성")
    void create() {
        assertThat(LADDER_DTO).isNotNull();
    }
}