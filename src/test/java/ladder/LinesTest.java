package ladder;

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
        Points points1 = new Points(List.of(new Point(false), new Point(true))); // 3명
        Points points2 = new Points(List.of(new Point(true), new Point(false))); // 3명
        Lines lines = new Lines(List.of(new Line(points1), new Line(points2))); // 2층

        Assertions.assertThat(lines.hasAtLeastOneBridge(3)).isTrue();
    }
}