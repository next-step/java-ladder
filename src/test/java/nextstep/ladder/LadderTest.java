package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_최소_1이상의_높이를_가져야_한다() {
        assertThatThrownBy(() -> Ladder.of(List.of(new Name("pobi"), new Name("honux")), new Lines(List.of())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 높이는 최소 1이상이어야 합니다.");
    }

    @Test
    void 사다리는_게임_실행_후_결과를_반환할_수_있다() {
        List<Name> playerNames = List.of(new Name("pobi"), new Name("honux"));
        Line line = lineOf(false, false);
        Lines lines = new Lines(List.of(line, line));

        Ladder ladder = new Ladder(playerNames, lines);

        assertThat(ladder.play()).isNotNull();
    }

    private Line lineOf(boolean first, boolean second) {
        return Line.from(List.of(new Point(first), new Point(second)));
    }

    @Test
    void 사다리_게임은_2명_미만의_참가자로는_생성할_수_없다() {
        assertThatThrownBy(() -> Ladder.of(List.of(new Name("pobi")), new Lines(List.of(Line.from(1)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 게임은 최소 2명 이상의 참가자가 있어야 합니다.");
    }

    @Test
    void 사다리_게임은_2명_이상의_참가자로_생성할_수_있다() {
        assertThatCode(() -> Ladder.of(List.of(new Name("pobi"), new Name("crong")), new Lines(List.of(Line.from(2)))))
                .doesNotThrowAnyException();
    }
}
