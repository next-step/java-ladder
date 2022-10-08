package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    public static final Player JUN = new Player("jun");
    
    @Test
    @DisplayName("플레이어 이름 생성")
    void create() {
        assertThat(JUN).isNotNull();
    }
    
    @Test
    @DisplayName("플레이어 이름 5자 초과시 예뢰")
    void player_name_length_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Player("honuxs"))
                .withMessage("플레이어 이름은 5자를 초과할 수 없습니다.");
    }
    
    @Test
    @DisplayName("플레이어 이름 가져오기")
    void get_player_name() {
        assertThat(JUN.getPlayerName()).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 게임 매칭 결과 받아오기")
    void get_ladder_game_result() {
        Map<String, String> map = new HashMap<>();
        
        JUN.putLadderGameResult(map, LadderResultsTest.LADDER_RESULTS);
        final String actual = map.get(JUN.getPlayerName().getPlayerName());
        
        assertThat(actual).isEqualTo("꽝");
    }
    
    @Test
    @DisplayName("플레이어 사다리 타고 이동하기")
    void move() {
        Map<String, String> map = new HashMap<>();
        
        JUN.move(LadderTest.LADDER.getLines());
        JUN.putLadderGameResult(map, LadderResultsTest.LADDER_RESULTS);
        final String actual = map.get(JUN.getPlayerName().getPlayerName());
        
        assertThat(actual).isEqualTo("5000");
    }
}