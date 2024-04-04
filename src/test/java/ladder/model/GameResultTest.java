package ladder.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    @DisplayName("게임 결과 출력 시 참여자가 아닌 이름 입력하면 에러")
    void check_game_result_one_player() {
        NameList nameList = new NameList("anna, pony, jiwoo");
        GameResultList gameResultList = new GameResultList("100,200,300", nameList.numOfName());

        GameResult gameResult = new GameResult(nameList,gameResultList);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            gameResult.makeResult("anno");
        });
    }
}
