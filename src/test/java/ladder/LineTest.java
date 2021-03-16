package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인 생성 테스트 좌표 갯수, 세로줄 생성여부, 가로줄 겹치는 여부 테스트")
    void create() {
        int countOfPerson = 5;
        Line line = new Line(5);

        assertThat(line.getPointList()
                .size()).isEqualTo(countOfPerson * 2 - 1);
        assertThat(isVerticalLineExist(line)).isTrue();
        assertThat(isOverlapping(line)).isFalse();
    }

    private boolean isVerticalLineExist(Line line) {
        List<Boolean> points = line.getPointList();
        for (int i = 0; i < points.size(); i += 2) {
            if(!points.get(i)) return false;
        }
        return true;
    }

    private boolean isOverlapping(Line line) {
        List<Boolean> points = line.getPointList();
        boolean lineIsConnectedBefore = false;
        for (int i = 1; i < points.size(); i += 2) {
            Boolean currentPointIsConnected = points.get(i);
            if (lineIsConnectedBefore && currentPointIsConnected) return true;
            lineIsConnectedBefore = currentPointIsConnected;
        }
        return false;
    }
}
