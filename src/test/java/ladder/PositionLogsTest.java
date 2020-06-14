package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionLogsTest {

    @DisplayName("라인을 내려가면 라인의 개수만큼 위치 로그가 늘어난다")
    @Test
    void moveDown() {
        PositionLogs positionLogs = PositionLogs.of(Arrays.asList(
                PositionLog.from(0),
                PositionLog.from(1),
                PositionLog.from(2)));

        LadderLines lines = new LadderLines(Arrays.asList(
                new LadderLine(4),
                new LadderLine(4),
                new LadderLine(4),
                new LadderLine(4)));

        positionLogs.moveDown(lines);
        List<PositionLog> logList = positionLogs.getContent();

        assertThat(logList.get(0).size()).isEqualTo(5);
        assertThat(logList.get(1).size()).isEqualTo(5);
        assertThat(logList.get(2).size()).isEqualTo(5);
    }
}
