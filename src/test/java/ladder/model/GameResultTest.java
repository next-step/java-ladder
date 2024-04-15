package ladder.model;

import ladder.model.utils.ConnectLine;
import ladder.model.utils.ConnectLineRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    @Test
    @DisplayName("게임 결과 출력 시 참여자가 아닌 이름 입력하면 에러")
    void check_game_result_one_player() {
        NameList nameList = new NameList("anna, pony, jiwoo");
        GameResultList gameResultList = new GameResultList("100,200,300", nameList.numOfName());

        GameResult gameResult = new GameResult(nameList, gameResultList);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameResult.makeResult("anno");
        });
    }

    @Test
    @DisplayName("게임의 올바른 수행 검증")
    void check_game_result() {
        NameList nameList = new NameList("anna, pony, ando");
        GameResultList gameResultList = new GameResultList("100, 200, 300", nameList.numOfName());
        ConnectLine connectLine = new ConnectLineRandom();

        GameResult gameResult = new GameResult(nameList, gameResultList);
        Line line = new Line(Arrays.asList(Boolean.TRUE, Boolean.FALSE),connectLine);
        Line line2 = new Line(Arrays.asList(Boolean.FALSE, Boolean.FALSE),connectLine);
        Ladder ladder = new Ladder(Arrays.asList(line, line2));
        gameResult.ladderGame(ladder);

        assertThat(gameResult.makeResult("anna")).isEqualTo("200");
        assertThat(gameResult.makeResult("pony")).isEqualTo("100");
        assertThat(gameResult.makeResult("ando")).isEqualTo("300");

    }
}
