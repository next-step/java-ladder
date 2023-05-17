package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    private Lines lines = new Lines();

    @BeforeEach
    void setUp() {
        lines.addLine(new Line(new Position(0, 0), new Position(1, 0)));
        lines.addLine(new Line(new Position(1, 1), new Position(2, 1)));
    }

    @DisplayName("Lines 클래스에 Line 클래스에 Position이 겹칠경우 addLine을 호출하더라도 Line이 추가되면 안된다.")
    @Test
    void 중복_라인_검증() {
        lines.addLine(new Line(new Position(1, 0), new Position(2, 0)));
        assertThat(lines.hasLine(new Line(new Position(1, 0), new Position(2, 0)))).isFalse();
    }

    @DisplayName("Lines 클래스에 Line 클래스에 Position이 겹치지 않을 경우 addLine 호출시 Line이 추가되야 한다.")
    @Test
    void 라인_추가_결과_검증() {
        lines.addLine(new Line(new Position(2, 0), new Position(3, 0)));
        assertThat(lines.hasLine(new Line(new Position(2, 0), new Position(3, 0)))).isTrue();
    }

    @ParameterizedTest(name = "라인에 이동과 관련된 테스트로 라인이 가지고있는 2개에 Position중 하나를 넘기게되면" +
            "반대에 Position에 높이가 1 증가한 Position 리턴되며 " +
            "아닐경우 높이만 1 증가한 Position이 리턴된다.")
    @CsvSource(value = {
            "0|0|1|1",
            "1|1|2|2",
            "2|2|2|3",
            "3|3|3|4",
    }, delimiter = '|')
    void 라인_이동_결과_검증(int x, int y, int next_x, int next_y) {
        assertThat(lines.move(new Position(x, y))).isEqualTo(new Position(next_x, next_y));
    }


}