package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    @DisplayName("인자로 GameInfo를 전달받아 사다리 게임을 생성한다.")
    @Test
    void createLottoGame() {
        // given
        String[] names = {"홍길동", "전창길", "코난"};
        Ladder ladder = new Ladder(List.of(
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, true)),
            new Bridges(List.of(true, false, false)),
            new Bridges(List.of(false, false, false)),
            new Bridges(List.of(false, true, false))
            ));

        GameInfo gameInfo = new GameInfo(names, ladder);

        // when & then
        assertThat(new LadderGame(gameInfo)).isEqualTo(new LadderGame(gameInfo));
    }
}
