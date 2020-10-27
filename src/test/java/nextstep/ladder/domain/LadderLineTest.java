package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 100})
    @DisplayName("사다리 라인(가로줄) 생성 테스트")
    void createHorizontalLineTest(int countOfPersons) {
        LadderLine line = LadderLine.init(countOfPersons);

        assertThat(line.getPoints().size()).isEqualTo(countOfPersons);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:0", "2:2"}, delimiterString = ":")
    @DisplayName("사다리 라인(가로줄)의 특정한 열에서 움직일 수 있는 방향으로 움직인다.")
    void moveTest(int col, int expectedMovedCol) {
        // |---|   | 생성
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, new Direction(false, true)));
        points.add(new Point(1, new Direction(true, false)));
        points.add(new Point(2, new Direction(false, false)));

        LadderLine line = new LadderLine(points);

        int movedCol = line.move(col);

        assertThat(movedCol).isEqualTo(expectedMovedCol);
    }

}
