package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerNameTest {
    public static final PlayerName PLAYER_NAME = new PlayerName("jun");
    
    @Test
    @DisplayName("플레이어 이름 생성")
    void create() {
        assertThat(PLAYER_NAME).isNotNull();
    }
    
    @Test
    @DisplayName("플레이어 이름 가져오기")
    void get_player_name() {
        assertThat(PLAYER_NAME.getPlayerName()).isEqualTo("jun");
    }
}