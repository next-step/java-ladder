package nextstep.ladder.factory;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import nextstep.ladder.dto.LadderInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderFactoryTest {

    @Test
    @DisplayName("입력 받은 이름으로 사다리를 생성 할 수 있다")
    void newLadder() {
        LadderInformation ladderInformation = new LadderInformation(2, 2);
        Ladder actual = LadderFactory.create(ladderInformation, () -> Boolean.TRUE);
        Ladder expected = new Ladder(List.of(new Line(List.of(Point.first(true), Point.first(true).last())),
                new Line(List.of(Point.first(true), Point.first(true).last()))));

        assertThat(actual).isEqualTo(expected);
    }
}
