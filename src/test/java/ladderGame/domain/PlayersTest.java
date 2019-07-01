package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("게임 참가자들 생성")
    public void create() {

        List<String> source = Arrays.asList("hello", "world", "nice");
        Players players = Players.of(source);
        assertThat(players.size()).isEqualTo(3);
    }
}