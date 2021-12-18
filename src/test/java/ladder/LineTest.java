package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("플레이어 수에 맞게 한 라인의 포인트 생성")
    @Test
    void 플레이어수_라인생성() {
        int countOfPlayers = 4;
        Line line = new Line(countOfPlayers);
        assertThat(line.numberOfPoints()).isEqualTo(4);
    }


    @DisplayName("라인의 마지막 점은 항상 false다")
    @Test
    void 라인_마지막점_false() {
        int countOfPlayers = 4;
        Line line = new Line(countOfPlayers);
        assertThat(line.hasRightLine(countOfPlayers - 1)).isFalse();
    }

    @DisplayName("point가 true면 오른쪽 가로 라인이 존재한다.")
    @Test
    void 라인_가로라인여부() {
        Line line = new Line(true, false, true, false);
        assertThat(line.hasRightLine(0)).isTrue();
    }
}
