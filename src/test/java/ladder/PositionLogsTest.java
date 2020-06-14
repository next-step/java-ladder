package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class PositionLogsTest {

    @DisplayName("라인을 내려가면 라인의 개수만큼 위치 로그가 늘어난다")
    @Test
    void moveDown() {
        int pointCount = 4, lineCount = 5;
        DrawingPointStrategy drawingPointStrategy = () -> LadderLinePoint.of(false);

        LadderLines lines = IntStream.range(0, lineCount)
                .mapToObj(i -> new LadderLine(pointCount, drawingPointStrategy))
                .collect(collectingAndThen(toList(), LadderLines::new));

        PositionLogs positionLogs = PositionLogs.of(Arrays.asList(
                PositionLog.from(0),
                PositionLog.from(1),
                PositionLog.from(2)));

        positionLogs.moveDown(lines);
        List<PositionLog> logList = positionLogs.getContent();

        assertThat(logList.get(0).size()).isEqualTo(lineCount + 1);
        assertThat(logList.get(1).size()).isEqualTo(lineCount + 1);
        assertThat(logList.get(2).size()).isEqualTo(lineCount + 1);
    }
}
