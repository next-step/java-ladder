package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class GameResultTest {

    @Test
    @DisplayName("gameResult를 나타내는지 확인")
    public void gameResultTest(){

        List<String> result = Arrays.asList("꽝","100","200","300");
//        GameResult gameResult = new GameResult(result);
//
//        assertAll(
//                ()->  assertThat(gameResult.showResult(0)).isEqualTo("꽝"),
//                ()->  assertThat(gameResult.showResult(1)).isEqualTo("100"),
//                ()->  assertThat(gameResult.showResult(2)).isEqualTo("200"),
//                ()->  assertThat(gameResult.showResult(3)).isEqualTo("300")
//
//        );


    }
}
