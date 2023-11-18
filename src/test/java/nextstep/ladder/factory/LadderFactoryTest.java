package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {

    @Test
    @DisplayName("입력 받은 이름으로 사다리를 생성 할 수 있다")
    void newLadder() {
        Ladder actual = LadderFactory.create(List.of("pobi", "honux"), 2, () -> Boolean.TRUE);
        Ladder expected = new Ladder(List.of(new Name("pobi"), new Name("honux")),
                List.of(new Line(List.of(Point.first(true), Point.first(true).last())),
                        new Line(List.of(Point.first(true), Point.first(true).last()))));

        assertThat(actual).isEqualTo(expected);
    }
}
