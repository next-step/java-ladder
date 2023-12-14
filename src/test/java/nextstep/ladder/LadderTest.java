package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderPlayers;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_최소_1이상의_높이를_가져야_한다() {
        assertThatThrownBy(() -> Ladder.of(new LadderPlayers(List.of(new Name("pobi"), new Name("honux"))), new Lines(List.of())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 높이는 최소 1이상이어야 합니다.");
    }

    @Test
    void 사다리는_게임_실행_후_결과를_반환할_수_있다() {
        LadderPlayers ladderPlayers = new LadderPlayers(List.of(new Name("pobi"), new Name("honux")));
        Line line = lineOf(false, false);
        Lines lines = new Lines(List.of(line, line));

        LadderResult expectedLadderResult = new LadderResult(Map.of(new Name("pobi"), "꽝", new Name("honux"), "1000"));

        Ladder ladder = new Ladder(ladderPlayers, lines);

        assertThat(ladder.play(List.of("꽝", "1000"))).isEqualTo(expectedLadderResult);
    }

    private Line lineOf(boolean first, boolean second) {
        return Line.from(List.of(new Point(first), new Point(second)));
    }
}
