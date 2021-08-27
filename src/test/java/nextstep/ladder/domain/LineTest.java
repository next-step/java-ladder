package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.HorizontalLineException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    @DisplayName("사다리의 하나의 행은 1 이상의 열을 가질수 있다.")
    void createOneLine(int countOfPerson, int expectedLineCount) {
        Line line = new Line(countOfPerson);
        assertThat(line.verticalLineCount()).isEqualTo(expectedLineCount);
    }


    @Test
    @DisplayName("세로라인이 1줄밖에 없을때 가로라인을 그릴경우, 예외를 던진다.")
    void canNotDrawHorizontalLineForSingleColumn() {
        Line line = new Line(1);
        assertThatThrownBy(() -> {
            line.drawHorizontalLine(0);
        }).isInstanceOf(HorizontalLineException.class);
    }

    @Test
    @DisplayName("가로라인은 같은 지점에 중복/연속해서 그릴경우, 예외를 던진다.")
    void canNotDrawDuplicateHorizontalLine() {
        Line line = new Line(2);
        line.drawHorizontalLine(0);
        assertThatThrownBy(() -> {
            line.drawHorizontalLine(0);
        }).isInstanceOf(HorizontalLineException.class);

    }


    @ParameterizedTest
    @CsvSource(value = {"2,0", "3,1", "4,2"})
    @DisplayName("세로라인이 2줄이상일때, 하나의 열에서 다른 열로 가로라인을 그릴수 있다.")
    void canDrawHorizontalLineForMultiColumns(int countOfPerson, int startPointIndex) {
        Line line = new Line(countOfPerson);
        line.drawHorizontalLine(startPointIndex);
        assertThat(line.hasHorizontalLine(startPointIndex)).isEqualTo(true);
        assertThat(line.hasHorizontalLine(startPointIndex + 1)).isEqualTo(true);
    }

    @Test
    void name() {

        Line line = new Line(10);
        line.drawHorizontalLine(0);


    }
}