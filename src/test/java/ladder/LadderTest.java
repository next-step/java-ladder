package ladder;

import ladder.model.Ladder;
import ladder.generator.RandomBooleanGenerator;
import ladder.model.Line;
import ladder.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @DisplayName("참여자 수, 사다리 높이 기준으로 사다리를 생성한다")
    @Test
    void create() {
        Ladder ladder = Ladder.of(4, 5, new RandomBooleanGenerator());
        assertThat(ladder.height()).isEqualTo(5);
    }

    @DisplayName("시작 위치 기반으로 최종 위치를 구한다")
    @Test
    void lastPosition() {
        Line line1 = new Line(List.of(new Point(0, false, false), new Point(1, false, false)));
        Line line2 = new Line(List.of(new Point(0, false, true), new Point(1, true, false)));

        Ladder ladder = new Ladder(List.of(line1, line2));

        assertThat(ladder.calculateLastPositionByIndex(0)).isEqualTo(1);
        assertThat(ladder.calculateLastPositionByIndex(1)).isEqualTo(0);
    }
}
