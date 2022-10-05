package ladder.step2.dto;

import ladder.step2fixture.dto.PlayerNameDTOFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameDTOTest {
    @Test
    @DisplayName("PlayerNameDTO 생성")
    void create() {
        assertThat(PlayerNameDTOFixture.PLAYER_NAME_DTO_JUN).isNotNull();
    }
}