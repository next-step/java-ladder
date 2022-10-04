package ladder.step2.domain.dto;

import ladder.step2.domain.LadderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderDTOTest {
    @Test
    @DisplayName("LadderDTO 생성")
    void create() {
        assertThat(LadderTest.LADDER.ladderInformation()).isNotNull();
    }
}