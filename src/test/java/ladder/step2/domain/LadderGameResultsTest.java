package ladder.step2.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameResultsTest {
    private static final HashMap<String, String> HASH_MAP = new HashMap<>();
    public static final LadderGameResults LADDER_GAME_RESULTS = new LadderGameResults(HASH_MAP);
    
    @BeforeAll
    static void beforeAll() {
        HASH_MAP.put("pobi", "5000");
        HASH_MAP.put("honuix", "꽝");
        HASH_MAP.put("jun", "notebook");
        HASH_MAP.put("jk", "꽝");
    }
    
    @Test
    @DisplayName("사다리 게임 결과 생성")
    void create() {
        assertThat(LADDER_GAME_RESULTS).isNotNull();
    }
    
    @Test
    @DisplayName("특정 플레이어의 결과 가져오기")
    void get_specific_data() {
        assertThat(LADDER_GAME_RESULTS.get("jun")).isEqualTo("notebook");
    }
    
    @Test
    @DisplayName("존재하지 않는 플레이어 예외")
    void not_exist_player_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> LADDER_GAME_RESULTS.get("ggg"))
                .withMessage("존재하지 않는 플레이어입니다. 다시 입력해주세요.");
    }
}