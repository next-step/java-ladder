package ladder.domain;

import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("플레이어 수에 맞게 한 라인의 포인트 생성")
    @Test
    void 플레이어수_라인생성() {
        Line line = TestLadderFactory.createRandomLine(4);
        assertThat(line.numberOfPoints()).isEqualTo(4);
    }


    @DisplayName("라인의 마지막 점은 항상 false다")
    @Test
    void 라인_마지막점_false() {
        Line line = TestLadderFactory.createRandomLine(4);
        assertThat(line.hasRightLine(3)).isFalse();
    }

    @DisplayName("point가 true면 오른쪽 가로 라인이 존재한다.")
    @Test
    void 라인_가로라인여부() {
        List<Boolean> points = Arrays.asList(true, false, true, false);
        Line line = Line.of(() -> points);
        assertThat(line.hasRightLine(0)).isTrue();
    }



}
