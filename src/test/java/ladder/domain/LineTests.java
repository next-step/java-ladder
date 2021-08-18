package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTests {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Line line = Line.of(Arrays.asList(true, false, false, true));

        assertThat(line).isEqualTo(Line.of(Arrays.asList(true, false, false, true)));
    }

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

    @DisplayName("Line move 시 오른쪽 제대로 움직이는지 테스트")
    @Test
    void moveRightTest() {
        Line line = Line.of(Arrays.asList(false, false, false, true));

        assertThat(line.move(2)).isEqualTo(3);
    }

    @DisplayName("Line move 시 왼쪽 제대로 움직이는지 테스트")
    @Test
    void moveLeftTest() {
        Line line = Line.of(Arrays.asList(false, false, true, false));

        assertThat(line.move(2)).isEqualTo(1);
    }
}
