package nextstep.ladder;

import nextstep.ladder.domain.ladder.Height;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    @DisplayName("사다리 라인 생성")
    void createLineTest() {
        int heightInteger = 5;
        int invalidHeightInteger = 0;
        List<Boolean> points = Arrays.asList(true,false,true,false,false);
        Line line = new Line(new Height(heightInteger), points);
        assertThat(line.getHeight()).isEqualTo(heightInteger);
        assertThatThrownBy(() -> {
            new Line(new Height(invalidHeightInteger), points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadderTest() {
        int heightInteger = 3;
        List<Boolean> points1 = Arrays.asList(true,false,true);
        List<Boolean> points2 = Arrays.asList(true,true,true);
        Line line1 = new Line(new Height(heightInteger), points1);
        Line line2 = new Line(new Height(heightInteger), points2);
        Ladder ladder = new Ladder(line1, line2);
        assertThat(ladder.getPoints()).isEqualTo(points1);
    }
}
