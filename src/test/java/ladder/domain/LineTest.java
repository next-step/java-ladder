package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @DisplayName("참가자 수에 맞게 라인 생성")
  @Test
  void createLine() {
    int countOfPerson = 4;
    Line line = new Line(countOfPerson, position -> Math.random() < 0.5);
    assertThat(line.getPointsSize()).isEqualTo(countOfPerson - 1);
  }

  @DisplayName("특정 위치에 point 생성")
  @Test
  void createPoint() {
    int countOfPerson = 4;
    Line line = new Line(countOfPerson, (position) -> position == 0);

    assertThat(line.hasPoint(0)).isTrue();
    assertThat(line.hasPoint(1)).isFalse();
    assertThat(line.hasPoint(2)).isFalse();
  }

  @DisplayName("이전 위치에 point가 있으면 현재 위치에는 point를 생성하지 않음")
  @Test
  void createPointWithPrevious() {
    int countOfPerson = 4;
    Line line = new Line(countOfPerson, (position) -> true);

    assertThat(line.hasPoint(0)).isTrue();
    assertThat(line.hasPoint(1)).isFalse();
    assertThat(line.hasPoint(2)).isTrue();
  }
}
