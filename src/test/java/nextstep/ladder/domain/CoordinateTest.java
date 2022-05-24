package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateTest {

    private List<Line> validLines;
    private List<Line> invalidLines;

    @BeforeEach
    void setUp() {
        validLines = List.of(
                Line.of(Arrays.asList(TRUE, TRUE, FALSE)),
                Line.of(Arrays.asList(FALSE, FALSE, TRUE))
        );

        invalidLines = List.of(
                Line.of(Arrays.asList(TRUE, TRUE, FALSE)),
                Line.of(Arrays.asList(TRUE, FALSE, TRUE))
        );
    }

    @Test
    void coordinate_createdFail() {
        assertThatThrownBy(() -> Coordinate.of(-1, -1))
                .isInstanceOf(LadderException.class);
    }

    @Test
    void coordinate_createdSuccess() {
        assertThat(Coordinate.of(1,1)).isEqualTo(Coordinate.of(1,1));
    }

    @DisplayName("좌표 한 개가 이동 성공")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0:1:1",
            "2:2:1:3"
    }, delimiter = ':')
    void coordinateGiven_moveSuccess(int x, int y, int x1, int y1) {
        Coordinate coordinate = new Coordinate(x, y);
        coordinate.move(validLines);
        assertThat(coordinate).isEqualTo(new Coordinate(x1,y1));
    }

    @DisplayName("바가 같은 라인에 2개가 있어 좌표 한 개가 이동 실패")
    @Test
    void coordinateGiven_moveFail() {
        Coordinate coordinate = new Coordinate(1, 0);
        assertThatThrownBy(() -> coordinate.move(invalidLines))
                .isInstanceOf(LadderException.class);
    }

    @Test
    void done() {
        assertThat(Coordinate.of(0,3).done(3)).isTrue();
    }
}
