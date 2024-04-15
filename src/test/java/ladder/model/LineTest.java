package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static ladder.model.Point.INVALID_POINT;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("Line 객체 생성")
    void testLine_constructLine_Success() {
        Line line = Line.of(
                        List.of(
                            Point.of(false, true),
                            Point.of(true, false)
                        )
                    );

        assertAll(
                "Assert the constructed line",
                () -> assertEquals(2, line.getSizeOfLine()),
                () -> assertTrue(line.isConnectedToNextLadder(0)),
                () -> assertFalse(line.isConnectedToNextLadder(1))
        );
    }

    @Test
    @DisplayName("사다리의 연달은 라인이 겹쳐서 에러 반환")
    void testLine_connectedLinesInARow_ShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Line.of(
                    List.of(
                            Point.of(true, true)
                    )
            );
        }).withMessageContaining(INVALID_POINT);
    }

    @ParameterizedTest(name = "해당 index가 다음 사다리와 연결되어있는지 결과 반환")
    @CsvSource(value = {"0:true", "1:false", "2:false"}, delimiter = ':')
    void testLine_isNotConnectedLadder_ShouldReturnFalse(int index, boolean isConnected) {
        Line line = Line.of(
                            List.of(
                                    Point.of(false, true),
                                    Point.of(true, false),
                                    Point.of(false, false)
                            )
                    );

        assertEquals(line.isConnectedToNextLadder(index), isConnected);
    }

    @ParameterizedTest(name = "해당 index에서 사다리를 한번 탈 경우 이동하는 거리를 반환")
    @CsvSource(value = {"0:1", "1:-1", "2:0"}, delimiter = ':')
    void testLine_moveByDistance_ShouldMoveLeft(int index, int movement) {
        Line line = Line.of(
                List.of(
                        Point.of(false, true),
                        Point.of(true, false),
                        Point.of(false, false)
                )
        );

        assertEquals(line.moveByDistance(index), movement);
    }

}
