package laddergame.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderPlayResultTest {
    
    @DisplayName("플레이어에 해당되는 당첨결과를 조회한다")
    @Test
    void get(){
        Player name1 = new Player("name1");
        Player name2 = new Player("name2");
        Map<Player, String> result = new HashMap<>();
        result.put(name1, "꽝");
        result.put(name2, "당첨");

        assertThat(result.get(name1)).isEqualTo("꽝");
        assertThat(result.get(name2)).isEqualTo("당첨");
    }
}
