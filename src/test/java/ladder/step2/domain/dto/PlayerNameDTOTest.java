package ladder.step2.domain.dto;

import ladder.step2.domain.PlayerNameTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameDTOTest {
    @Test
    @DisplayName("PlayerNameDTO 생성")
    void create() {
        assertThat(PlayerNameTest.JUN.playerNameInformation()).isNotNull();
    }
}