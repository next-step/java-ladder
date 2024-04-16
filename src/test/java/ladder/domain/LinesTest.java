package ladder.domain;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Point;
import ladder.domain.Points;
import ladder.fixture.Fixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LinesTest {
    @DisplayName("층 수 만큼 라인이 생성되어야 합니다.")
    @Test
    void linesCount() {
        Lines lines = new Lines(10, 3);
        Assertions.assertThat(lines.getLines().size()).isEqualTo(10);
    }

    @DisplayName("player가 탈 사다리가 적어도 하나의 다리를 가지고있는지 확인한다. - 2층 사다리(line 2개), 3명의 참여자(point 2개)")
    @Test
    void hasAtLeastOneBridge_false() {
        Points points = new Points(List.of(new Point(false), new Point(false)));
        Lines lines = new Lines(List.of(new Line(points), new Line(points)));

        Assertions.assertThat(lines.hasAtLeastOneBridge(3)).isFalse();
    }

    @DisplayName("player가 탈 사다리가 적어도 하나의 다리를 가지고있는지 확인한다. - 2층 사다리(line 2개), 3명의 참여자(point 2개)")
    @Test
    void hasAtLeastOneBridge_true() {
        Lines lines = Fixture.makeInvalidLines();
        Assertions.assertThat(lines.hasAtLeastOneBridge(3)).isTrue();
    }

    @DisplayName("player의 위치에 해당하는 인덱스에 Brige가 있으면 우측으로, 위치의 -1에 해당하는 인덱스에 Bridge가 있으면 좌측으로 이동한다.")
    @Test
    void runPlayerGoLines() {
        Lines lines = Fixture.makeValidLines();

        Assertions.assertThat(lines.runPlayerGoLines(0)).isEqualTo(1);
        Assertions.assertThat(lines.runPlayerGoLines(1)).isEqualTo(2);
        Assertions.assertThat(lines.runPlayerGoLines(2)).isEqualTo(0);
    }
}