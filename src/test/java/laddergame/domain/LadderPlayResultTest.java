package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPlayResultTest {

    @DisplayName("플레이어의 최종 위치와 연결된 게임 결과를 알 수 있다")
    @Test
    void getGameResult(){
        Player player = new Player("name1", 0);
        LadderPlayResult playResult = new LadderPlayResult();

        playResult.add(new Player("name1", 0), "꽝");

        assertThat(playResult.get(player)).isEqualTo("꽝");
    }
}