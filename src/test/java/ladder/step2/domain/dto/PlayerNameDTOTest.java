package ladder.step2.domain.dto;

import ladder.step2.domain.PlayerNameTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameDTOTest {
    public static final PlayerNameDTO PLAYER_NAME_DTO_JUN = new PlayerNameDTO(PlayerNameTest.JUN.playerNameInformation().getPlayerName());
    
    @Test
    @DisplayName("PlayerNameDTO 생성")
    void create() {
        assertThat(PLAYER_NAME_DTO_JUN).isNotNull();
    }
}