package nextstep.ladder2.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("생성 테스트")
    void create(){
        Players players = Players.of("a,b,c,d");

        assertThat(players.names()).contains("a","b","c","d");
        assertThat(players.indexes()).contains(0,1,2,3);
    }

    @Test
    @DisplayName("선수들 움직이기")
    void movePlayersTest(){
        List<Direction> directions = Arrays.asList(new Direction[]{Direction.RIGHT,Direction.LEFT,Direction.STAY,Direction.STAY});
        System.out.println(directions);
        Players players = Players.of("a,b,c,d");
        players.move(directions);
        assertThat(players.indexes()).containsExactly(1,0,2,3);
    }


}