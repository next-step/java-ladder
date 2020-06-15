package ladder;

import ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class PositionLogsTest {

    @DisplayName("라인을 내려가면 라인의 개수만큼 위치 로그가 늘어난다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveDown(int logsIndex) {
        int pointCount = 4, lineCount = 5;
        DrawingPointStrategy drawingPointStrategy = () -> LadderLinePoint.of(false);
        LadderLines lines = IntStream.range(0, lineCount)
                .mapToObj(i -> new LadderLine(pointCount, drawingPointStrategy))
                .collect(collectingAndThen(toList(), LadderLines::new));

        PositionLogs positionLogs = PositionLogs.of(Arrays.asList(
                PositionLog.from(0),
                PositionLog.from(1),
                PositionLog.from(2),
                PositionLog.from(3)));

        positionLogs.moveDown(lines);
        List<PositionLog> logList = positionLogs.getContent();

        assertThat(logList.get(logsIndex).size()).isEqualTo(lineCount + 1);
    }

    @DisplayName("처음 위치가 마지막에 어느 위치로 이어지는지 확인한다")
    @ParameterizedTest
    @CsvSource({"0, 1", "1, 0", "2, 3", "3, 2", "4, 4"})
    void getLastPosition(int initialPosition, int expected) {
        int pointCount = 5, lineCount = 3;
        DrawingPointStrategy drawingPointStrategy = () -> LadderLinePoint.of(true);
        LadderLines lines = IntStream.range(0, lineCount)
                .mapToObj(i -> new LadderLine(pointCount, drawingPointStrategy))
                .collect(collectingAndThen(toList(), LadderLines::new));

        PositionLogs positionLogs = PositionLogs.of(Arrays.asList(
                PositionLog.from(0),
                PositionLog.from(1),
                PositionLog.from(2),
                PositionLog.from(3),
                PositionLog.from(4)));

        positionLogs.moveDown(lines);
        int lastPosition = positionLogs.getLastPosition(initialPosition);

        assertThat(lastPosition).isEqualTo(expected);
    }
}
