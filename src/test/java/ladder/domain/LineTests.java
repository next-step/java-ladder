package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTests {

    @DisplayName("Line size 테스트")
    @Test
    void getSizeTest() {
        Line line = Line.of(4);

        assertThat(line.getSize()).isEqualTo(4);
    }

    @DisplayName("Line 생성될 때 인접한 상태 값은 달라야 함")
    @Test
    void adjacentPointsTest() {
        Line line = Line.of(4);

        System.out.println(line.havePoints(1));
        System.out.println(line.havePoints(2));

        assertThat(line.havePoints(1)).isNotEqualTo(line.havePoints(2));
    }
}
