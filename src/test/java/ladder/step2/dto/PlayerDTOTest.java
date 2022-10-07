package ladder.step2.dto;

import ladder.step2.domain.PlayerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerDTOTest {
    public static final PlayerDTO PLAYER_NAME_DTO_JUN = new PlayerDTO(PlayerTest.JUN);
    
    @Test
    @DisplayName("PlayerNameDTO 생성")
    void create() {
        assertThat(PLAYER_NAME_DTO_JUN).isNotNull();
    }
    
    @Test
    @DisplayName("PlayerNameDTO 데이터 가져오기")
    void is_exist_data() {
        assertThat(PLAYER_NAME_DTO_JUN.getPlayerName()).isEqualTo(PLAYER_NAME_DTO_JUN.getPlayerName());
    }
}