package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.GenerateLadderPoint;
import nextstep.ladder.domain.strategy.RandomLadderPoint;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LineTest {
    @Test
    @DisplayName("랜덤 포인트를 가진 라인을 생성할 수 있다")
    void create() {
        int namesSize = 5;
        GenerateLadderPoint generateLadderPoint = new RandomLadderPoint();

        Line line = new Line(namesSize, generateLadderPoint);
        List<Boolean> points = line.getPoints();

        Assertions.assertThat(namesSize - 1).isEqualTo(points.size());
    }
}