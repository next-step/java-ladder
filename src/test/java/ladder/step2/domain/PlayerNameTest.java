package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayerNameTest {
    public static final PlayerName JUN = new PlayerName("jun");
    
    @Test
    @DisplayName("플레이어 이름 생성")
    void create() {
        assertThat(PlayerNameTest.JUN).isNotNull();
    }
    
    @Test
    @DisplayName("플레이어 이름 5자 초과시 예뢰")
    void player_name_length_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new PlayerName("honuxs"))
                .withMessage("플레이어 이름은 5자를 초과할 수 없습니다.");
    }
    
    @Test
    @DisplayName("플레이어 이름 dto 생성")
    void player_name_dto() {
        assertThat(PlayerNameTest.JUN.playerNameInformation().getPlayerName()).isEqualTo("jun");
    }
}