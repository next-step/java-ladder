package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    
    @DisplayName("사다리 게임 실행 후, 플레이어별 실행 결과를 조회한다")
    @Test
    void play(){
        //given
        Player name1 = new Player("name1", 0);
        Player name2 = new Player("name2", 1);
        Players players = new Players(List.of(name1, name2));

        LadderResult result = new LadderResult(List.of("꽝", "당첨"));

        Line line = new Line(List.of(true));
        Ladder ladder = new Ladder(List.of(line));

        //when
        /*
          name1   name2
            |------|
           꽝      성공

         * 결과
         name1 : 당첨
         name2 : 꽝
        */
        LadderGame game = new LadderGame(players, ladder, result);
        LadderPlayResult playResult = game.play();

        assertThat(playResult.get(name1)).isEqualTo("당첨");
        assertThat(playResult.get(name2)).isEqualTo("꽝");
    }

}