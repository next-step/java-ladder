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


    @DisplayName("사다리 생성가능 여부를 판단하는 메서드를 검증한다")
    @Test
    public void canMakeLine() {
        //given
        Line line11 = new Line(1, 1);
        Line line22 = new Line(2, 2);
        Lines lines = new Lines(Set.of(line11, line22));
        Line line33 = new Line(3, 3);
        Line line23 = new Line(2, 3);
        Line line21 = new Line(2, 1);
        Line line12 = new Line(1, 2);
        //when
        //then
        assertAll("Lines 가 입력한 파라미터에 맞게 생성된다",
                () -> assertThat(lines.isExistSameColumnAndAdjacentRow(line33))
                        .as("line33 은 SameColumn && AdjacentRow 에 위치하지 않는다")
                        .isFalse(),
                () -> assertThat(lines.isExistSameColumnAndAdjacentRow(line23))
                        .as("line23 은 SameColumn && AdjacentRow 에 위치한다")
                        .isTrue(),
                () -> assertThat(lines.isExistSameColumnAndAdjacentRow(line21))
                        .as("line21 은 SameColumn && AdjacentRow 에 위치한다")
                        .isTrue(),
                () -> assertThat(lines.isExistSameColumnAndAdjacentRow(line12))
                        .as("line33 은 SameColumn && AdjacentRow 에 위치한다")
                        .isTrue()
        );

    }
}