package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {
    @DisplayName("동일한 column, row 를 갖는 Line 이면 인스턴스가 다르더라도 동일한 객체로 취급하는 로직을 검증")
    @Test
    public void equals() {
        //given
        Line line11 = new Line(1, 1);
        Line line22A = new Line(2, 2);
        Line line22B = new Line(2, 2);
        Line comparativeLine11 = new Line(1, 1);

        //when
        //then
        assertAll("동등성을 검증한다",
                () -> assertThat(line22A)
                        .as("column, row 숫자가 동일하면 equal 하다")
                        .isEqualTo(line22B),
                () -> assertThat(line11)
                        .as("column, row 숫자가 다르면 equal 하지않다")
                        .isNotEqualTo(line22A),
                () -> assertThat(comparativeLine11.isSame(1, 1))
                        .as("column, row 숫자가 동일하면 isSame 메서드가 True 를 반환한다")
                        .isTrue(),
                () -> assertThat(comparativeLine11.isSame(2, 1))
                        .as("column, row 숫자가 다르면 isSame 메서드가 False 를 반환한다")
                        .isFalse(),
                () -> assertThat(comparativeLine11.isSame(1, 2))
                        .as("column, row 숫자가 다르면 isSame 메서드가 False 를 반환한다")
                        .isFalse(),
                () -> assertThat(comparativeLine11.isSame(2, 2))
                        .as("column, row 숫자가 다르면 isSame 메서드가 False 를 반환한다")
                        .isFalse()
        );
    }

    @DisplayName("두 Line 이 같은 Row 에 존재하는지 판단하는 메서드 isSameRow() 를 검증한다")
    @Test
    public void isSameRow() {
        //given
        Line benchmarkLine = new Line(2, 2);
        Line notSameRowLineA = new Line(2, 3);
        Line notSameRowLineB = new Line(2, 1);
        Line sameRowLineA = new Line(1, 2);
        Line sameRowLineB = new Line(11, 2);
        //when
        //then
        assertAll("isSameRow() 메서드를 검증한다",
                () -> assertThat(benchmarkLine.isSameRow(notSameRowLineA))
                        .as("서로다른 Row 에 존재한다")
                        .isFalse(),
                () -> assertThat(benchmarkLine.isSameRow(notSameRowLineB))
                        .as("서로다른 Row 에 존재한다")
                        .isFalse(),
                () -> assertThat(benchmarkLine.isSameRow(sameRowLineA))
                        .as("같은 Row 에 존재한다")
                        .isFalse(),
                () -> assertThat(benchmarkLine.isSameRow(sameRowLineB))
                        .as("같은 Row 에 존재한다")
                        .isFalse()
        );
    }


    @DisplayName("두 Line 이 서로 인접한 Colum 에 존재하는지 확인하는 isAdjacentColumn() 을 검증한다")
    @Test
    public void isAdjacentColumn() {
        //given
        Line benchmarkLine = new Line(2, 2);
        Line notAdjacentA = new Line(1, 2);
        Line notAdjacentB = new Line(11, 2);
        Line adjacentLineA = new Line(2, 3);
        Line adjacentLineB = new Line(2, 1);
        //when
        //then
        assertAll("isAdjacentColumn() 메서드를 검증한다",
                () -> assertThat(benchmarkLine.isAdjacentColumn(notAdjacentA))
                        .as("서로 인접하지 않은 Column 에 존재한다")
                        .isFalse(),
                () -> assertThat(benchmarkLine.isAdjacentColumn(notAdjacentB))
                        .as("서로 인접하지 않은 Column 에 존재한다")
                        .isFalse(),
                () -> assertThat(benchmarkLine.isAdjacentColumn(adjacentLineA))
                        .as("인접한 Column 에 존재한다")
                        .isTrue(),
                () -> assertThat(benchmarkLine.isAdjacentColumn(adjacentLineB))
                        .as("인접한 Column 에 존재한다")
                        .isTrue()
        );
    }

    @DisplayName("전략에 따라 Line 을 생성하는 any 메서드를 검증한다")
    @Test
    public void any() {
        //given
        //when
        //then
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