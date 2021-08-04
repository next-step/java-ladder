package nextstep.ladder.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPlayerGameResultTest {

    @DisplayName("Map<String, PlayerRecord>으로 LadderPlayerGameResult 객체를 만들 수 있다")
    @Test
    void should_make_LadderPlayerGameResult() {
        //arrange
        Map<String, PlayerRecord> map = new HashMap<String, PlayerRecord>() {{
            put("player1", PlayerRecord.of("record1"));
        }};

        //act, assert
        assertThat(LadderPlayerGameResult.of(map)).isInstanceOf(LadderPlayerGameResult.class);
    }

    @DisplayName("Player name 목록을 반환한다")
    @Test
    void should_return_player_names() {
        //arrange
        Map<String, PlayerRecord> map = new HashMap<String, PlayerRecord>() {{
            put("player1", PlayerRecord.of("record1"));
            put("player2", PlayerRecord.of("record2"));
        }};

        //act, assert
        assertThat(LadderPlayerGameResult.of(map).getPlayers()).containsAll(Arrays.asList("player1", "player2"));
    }

    @DisplayName("Player의 record 목록을 반환한다")
    @Test
    void should_return_record() {
        //arrange
        Map<String, PlayerRecord> map = new HashMap<String, PlayerRecord>() {{
            put("player1", PlayerRecord.of("record1"));
            put("player2", PlayerRecord.of("record2"));
        }};

        //act, assert
        assertThat(LadderPlayerGameResult.of(map).getRecords("player1")).isEqualTo("record1");
    }

}