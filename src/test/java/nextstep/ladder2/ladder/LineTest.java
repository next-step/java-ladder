package nextstep.ladder2.ladder;

import nextstep.ladder2.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("생성 테스트")
    void create(){
        LineMaker maker = size1 -> true;
        Line line = new Line(maker,4);

        assertThat(line.showLine().size()).isEqualTo(4);
    }

    @Test
    @DisplayName("라인에서 플레이어를 움직인다.")
    void moveTest(){
        Players players = Players.of("a,b,c,d,e");

        LineMaker maker = size1 -> true;
        Line line = new Line(maker,4);

        assertThat(players.indexes()).containsExactly(0,1,2,3,4);

        line.playLadderLine(players);

        assertThat(players.indexes()).containsExactly(1,0,3,2,4);
    }
}