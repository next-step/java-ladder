package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

  @DisplayName("Lines 가 생성된다")
  @Test
  public void linesInstance() {
    Ladder ladder = Ladder.of(40, 20);
    assertAll("Lines 가 입력한 파라미터에 맞게 생성되어야 한다",
        () -> assertThat(ladder.allLines())
            .as("모든 Line 의 존재여부를 검증한다")
            .allMatch(ladder::existLine),
        () -> assertThat(ladder.allLines())
            .as("모든 Line 은 CrossIntersection 하지 않음을 검증한다")
            .allMatch(ladder::hasCrossIntersection)
    );
  }

  @DisplayName("존재여부 확인")
  @Test
  public void exisit() {
    Line line11 = new Line(1, 1);
    Line line22 = new Line(2, 2);
    Ladder ladder = Ladder.of(3, 3, Set.of(line11, line22));

    assertAll("존재 여부를 확인",
        () -> assertThat(ladder.existLine(line11))
            .as("값이 같고, 인스턴스도 같은 Line 이 존재할때 True 를 반환한다")
            .isTrue(),
        () -> assertThat(ladder.existLine(line22))
            .as("값이 같고, 인스턴스도 같은 Line 이 존재할때 True 를 반환한다")
            .isTrue(),
        () -> assertThat(ladder.existLine(new Line(Column.of(1), Row.of(1))))
            .as("값은 같지만, 인스턴스가 다른 Line 이 존재할때 True 를 반환한다")
            .isTrue(),
        () -> assertThat(ladder.existLine(new Line(Column.of(2), Row.of(2))))
            .as("값은 같지만, 인스턴스가 다른 Line 이 존재할때 True 를 반환한다")
            .isTrue(),
        () -> assertThat(ladder.existLine(new Line(3, 3)))
            .as("값이 다른 인스턴스는 False 를 반환한다")
            .isFalse()
    );
  }

  @DisplayName("사다리 생성가능 여부를 판단하는 메서드를 검증한다")
  @Test
  public void canMakeLine() {
    Line lineA = new Line(11, 11);
    Line lineB = new Line(6, 6);
    Ladder ladder = Ladder.of(12, 12, Set.of(lineA, lineB));

    assertAll("Lines 가 입력한 파라미터에 맞게 생성된다",
        () -> assertThat(ladder.hasCrossIntersection(new Line(3, 3)))
            .as("notNearA 은 SameColumn && AdjacentRow 에 위치하지 않는다")
            .isFalse(),
        () -> assertThat(ladder.hasCrossIntersection(new Line(10, 11)))
            .as("nearA 은 SameColumn && AdjacentRow 에 위치한다")
            .isTrue(),
        () -> assertThat(ladder.hasCrossIntersection(new Line(7, 6)))
            .as("nearB1 은 SameColumn && AdjacentRow 에 위치한다")
            .isTrue(),
        () -> assertThat(ladder.hasCrossIntersection(new Line(5, 6)))
            .as("nearB2 은 SameColumn && AdjacentRow 에 위치한다")
            .isTrue(),
        () -> assertThat(ladder.hasCrossIntersection(new Line(6, 7)))
            .as("line33 은 SameColumn && AdjacentRow 에 위치한다")
            .isFalse(),
        () -> assertThat(ladder.hasCrossIntersection(new Line(6, 5)))
            .as("line33 은 SameColumn && AdjacentRow 에 위치한다")
            .isFalse()
    );
  }
}
