package ladder.step2.dto;

import ladder.step2.domain.PlayersTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersDTOTest {
    public static final PlayersDTO PLAYERS_DTO = new PlayersDTO(PlayersTest.PLAYERS);
    
    @Test
    @DisplayName("PlayerDTO 생성")
    void create() {
        assertThat(PLAYERS_DTO).isNotNull();
    }
    
    @Test
    @DisplayName("PlayerDTOS 데이터 가져오기")
    void get_player_dtos() {
        assertThat(PLAYERS_DTO.getPlayerDTOS()).isNotNull();
    }
}