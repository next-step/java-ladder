package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPlayResultTest {

    @DisplayName("플레이어 정보로부터 게임 결과 조회가 가능하다")
    @Test
    void getGameResult(){
        Map<Player, String> result = new LinkedHashMap<>();
        Player name1 = new Player("name1", 0);
        result.put(name1, "성공");
        LadderPlayResult playResult = new LadderPlayResult(result);

        assertThat(playResult.get(name1)).isEqualTo("성공");
    }
}