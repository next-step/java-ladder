package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LinesTest {
    @DisplayName("Lines 가 생성된다")
    @Test
    public void linesInstance() {
        //given
        //when
        Lines lines = Lines.of(40, 20, 20);
        //then
        assertAll("Lines 가 입력한 파라미터에 맞게 생성된다",
                () -> assertThat(lines.lineCount())
                        .as("생성 라인 수대로 잘 만들어진다")
                        .isEqualTo(20),
                () -> assertThat(lines.allLines())
                        .as("모든 Line 의 존재여부를 확인할 수 있다")
                        .allMatch(lines::existLine)
        );
    }

    @DisplayName("존재여부 확인")
    @Test
    public void exisit() {
        //given
        Line line11 = new Line(1, 1);
        Line line22 = new Line(2, 2);
        Lines lines = new Lines(Set.of(line11, line22));

        //when
        Line newLine11 = new Line(Column.of(1), Row.of(1));
        Line newLine22 = new Line(Column.of(2), Row.of(2));
        Line line33 = new Line(3, 3);
        //then
        assertAll("존재 여부를 확인",
                () -> assertThat(lines.existLine(line11))
                        .as("값이 같고, 인스턴스도 같은 Line 이 존재할때 True 를 반환한다")
                        .isTrue(),
                () -> assertThat(lines.existLine(line22))
                        .as("값이 같고, 인스턴스도 같은 Line 이 존재할때 True 를 반환한다")
                        .isTrue(),
                () -> assertThat(lines.existLine(newLine11))
                        .as("값은 같지만, 인스턴스가 다른 Line 이 존재할때 True 를 반환한다")
                        .isTrue(),
                () -> assertThat(lines.existLine(newLine22))
                        .as("값은 같지만, 인스턴스가 다른 Line 이 존재할때 True 를 반환한다")
                        .isTrue(),
                () -> assertThat(lines.existLine(line33))
                        .as("값이 다른 인스턴스는 False 를 반환한다")
                        .isFalse()
        );
    }

    @DisplayName("사다리 생성가능 여부를 판단하는 메서드를 검증한다")
    @Test
    public void canMakeLine() {
        //given
        Line lineA = new Line(11, 11);
        Line lineB = new Line(6, 6);
        Lines lines = new Lines(Set.of(lineA, lineB));

        Line notNearA = new Line(3, 3);
        Line nearA = new Line(10, 11);
        Line nearB1 = new Line(7, 6);
        Line nearB2 = new Line(5, 6);
        Line notNearB1 = new Line( 6,7);
        Line notNearB2 = new Line(6,5);
        //when
        //then
        assertAll("Lines 가 입력한 파라미터에 맞게 생성된다",//isExistSameColumnAndAdjacentRow
                () -> assertThat(lines.hasCrossIntersection(notNearA))
                        .as("notNearA 은 SameColumn && AdjacentRow 에 위치하지 않는다")
                        .isFalse(),
                () -> assertThat(lines.hasCrossIntersection(nearA))
                        .as("nearA 은 SameColumn && AdjacentRow 에 위치한다")
                        .isTrue(),
                () -> assertThat(lines.hasCrossIntersection(nearB1))
                        .as("nearB1 은 SameColumn && AdjacentRow 에 위치한다")
                        .isTrue(),
                () -> assertThat(lines.hasCrossIntersection(nearB2))
                        .as("nearB2 은 SameColumn && AdjacentRow 에 위치한다")
                        .isTrue(),
                () -> assertThat(lines.hasCrossIntersection(notNearB1))
                        .as("line33 은 SameColumn && AdjacentRow 에 위치한다")
                        .isFalse(),
                () -> assertThat(lines.hasCrossIntersection(notNearB2))
                        .as("line33 은 SameColumn && AdjacentRow 에 위치한다")
                        .isFalse()

        );

    }
}