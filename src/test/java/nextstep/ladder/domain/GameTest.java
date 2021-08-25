package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Line;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @DisplayName("Player 리스트와 Line 리스트를 매개변수로 게임을 생성한다.")
    @Test
    void create() {
        String playerNames = "pobi,honux,crong,jk";
        List<Line> lines = Lists.list(Line.from(true, false, true), Line.from(true, false, true));
        assertThat(Game.of(playerNames, lines)).isEqualTo(Game.of(playerNames, lines));
    }
}
