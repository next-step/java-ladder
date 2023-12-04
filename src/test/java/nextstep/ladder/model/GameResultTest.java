package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {
    @Test
    @DisplayName("사람 이름 중 참여하지 않은 사람은 입력할 수 없다.")
    void test1() {
        //given
        GameResult gameResult = new GameResult(new HashMap<>(){{
            put("pobi", "당첨");
        }});
        assertThatThrownBy(() -> gameResult.getPeopleResult("qweadzs"))
                .hasMessageContaining("게임에 참여한 사람이 아닙니다");
    }
}