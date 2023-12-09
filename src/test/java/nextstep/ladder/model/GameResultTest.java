package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import nextstep.ladder.model.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @DisplayName("사다리 게임의 결과는 숫자, 문자 상관 없다.")
    @Test
    void ladderGameResultWithAnyWordsAnyDigit(){
        String origin = "성공, 꽝, 100, 0";
        GameResult gameResult = GameResult.of(origin);
        assertThat(gameResult.list().size()).isEqualTo(4);
        assertThat(gameResult.list().get(0)).isEqualTo("성공");
        assertThat(gameResult.list().get(3)).isEqualTo("0");
    }

}
