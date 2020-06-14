package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PositionLogTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void from() {
        int initialPosition = 3;
        PositionLog positionLog = PositionLog.from(initialPosition);
        List<Integer> positions = positionLog.getContent();

        assertThat(positions.get(0)).isEqualTo(initialPosition);
    }

    @DisplayName("라인을 내려가면 라인의 개수만큼 위치 로그가 늘어난다")
    @Test
    void moveDown() {
        LadderLines lines = new LadderLines(Arrays.asList(
                new LadderLine(3),
                new LadderLine(3),
                new LadderLine(3)));

        PositionLog positionLog = PositionLog.from(0);

        positionLog.moveDown(lines);

        assertThat(positionLog.size()).isEqualTo(4);
    }
}
