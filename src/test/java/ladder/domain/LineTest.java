package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.utils.LineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @DisplayName("동일한 column, row 를 갖는 Line 이면 인스턴스가 다르더라도 동일한 객체로 취급하는 로직을 검증")
  @Test
  public void equals() {
    Line benchmarkLine = new Line(1, 1);

    assertAll("동등성을 검증한다",
        () -> assertThat(new Line(2, 2))
            .as("column, row 숫자가 동일하면 equal 하다")
            .isEqualTo(new Line(2, 2)),
        () -> assertThat(new Line(1, 1))
            .as("column, row 숫자가 다르면 equal 하지않다")
            .isNotEqualTo(new Line(2, 2)),
        () -> assertThat(benchmarkLine.isSame(1, 1))
            .as("column, row 숫자가 동일하면 isSame 메서드가 True 를 반환한다")
            .isTrue(),
        () -> assertThat(benchmarkLine.isSame(2, 1))
            .as("column, row 숫자가 다르면 isSame 메서드가 False 를 반환한다")
            .isFalse(),
        () -> assertThat(benchmarkLine.isSame(1, 2))
            .as("column, row 숫자가 다르면 isSame 메서드가 False 를 반환한다")
            .isFalse(),
        () -> assertThat(benchmarkLine.isSame(2, 2))
            .as("column, row 숫자가 다르면 isSame 메서드가 False 를 반환한다")
            .isFalse()
    );
  }

  @DisplayName("두 Line 이 같은 Row 에 존재하는지 판단하는 메서드 isSameRow() 를 검증한다")
  @Test
  public void isSameRow() {
    Line benchmarkLine = new Line(2, 2);

    assertAll("isSameRow() 메서드를 검증한다",
        () -> assertThat(benchmarkLine.isSameRow(new Line(2, 3)))
            .as("서로다른 Row 에 존재한다")
            .isFalse(),
        () -> assertThat(benchmarkLine.isSameRow(new Line(2, 1)))
            .as("서로다른 Row 에 존재한다")
            .isFalse(),
        () -> assertThat(benchmarkLine.isSameRow(new Line(1, 2)))
            .as("같은 Row 에 존재한다")
            .isTrue(),
        () -> assertThat(benchmarkLine.isSameRow(new Line(11, 2)))
            .as("같은 Row 에 존재한다")
            .isTrue()
    );
  }


  @DisplayName("두 Line 이 서로 인접한 Colum 에 존재하는지 확인하는 isAdjacentColumn() 을 검증한다")
  @Test
  public void isAdjacentColumn() {
    Line benchmarkLine = new Line(2, 2);
    assertAll("isAdjacentColumn() 메서드를 검증한다",
        () -> assertThat(benchmarkLine.isAdjacentColumn(new Line(1, 2)))
            .as("서로 인접하지 않은 Column 에 존재한다")
            .isTrue(),
        () -> assertThat(benchmarkLine.isAdjacentColumn(new Line(11, 2)))
            .as("서로 인접하지 않은 Column 에 존재한다")
            .isFalse(),
        () -> assertThat(benchmarkLine.isAdjacentColumn(new Line(2, 3)))
            .as("인접한 Column 에 존재한다")
            .isTrue(),
        () -> assertThat(benchmarkLine.isAdjacentColumn(new Line(2, 1)))
            .as("인접한 Column 에 존재한다")
            .isTrue()
    );
  }

  @DisplayName("전략에 따라 Line 을 생성하는 any 메서드를 검증한다")
  @Test
  public void any() {
    assertAll("",
        () -> assertThat(Line.any(
            new LineStrategy() {
              @Override
              public int anyRow() {
                return 0;
              }

              @Override
              public int anyColumn() {
                return 0;
              }
            }))
            .as("항상 0,0 을 생성하는 전략")
            .isEqualTo(new Line(0, 0)),
        () -> assertThat(Line.any(
            new LineStrategy() {
              @Override
              public int anyRow() {
                return 33;
              }

              @Override
              public int anyColumn() {
                return 33;
              }
            }))
            .as("항상 33,33 을 생성하는 전략")
            .isEqualTo(new Line(33, 33))
    );
  }
}
