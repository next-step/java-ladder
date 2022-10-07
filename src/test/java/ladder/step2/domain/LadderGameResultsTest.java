package ladder.step2.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultsTest {
    private static final HashMap<String, String> HASH_MAP = new HashMap<>();
    public static final LadderGameResults LADDER_GAME_RESULTS = new LadderGameResults(HASH_MAP);
    
    static  {
        HASH_MAP.put("pobi", "5000");
        HASH_MAP.put("honux", "꽝");
        HASH_MAP.put("jun", "notebook");
        HASH_MAP.put("jk", "꽝");
    }
    
    @Test
    @DisplayName("사다리 게임 결과 생성")
    void create() {
        assertThat(LADDER_GAME_RESULTS).isNotNull();
    }
    
    @Test
    @DisplayName("사다리 게임 결과 데이터 가져오기")
    void get_ladder_game_results() {
        assertThat(LADDER_GAME_RESULTS.getLadderGameResults()).isEqualTo(HASH_MAP);
    }
}