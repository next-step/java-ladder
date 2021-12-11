package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("Line 생성자 테스트")
    void constructor() {
        assertThat(new Line(Arrays.asList(new Point(false, true), new Point(false, false))))
                .isEqualTo(new Line(Arrays.asList(new Point(false, true), new Point(false, false))));
    }

    @Test
    @DisplayName("참가자 수 만큼의 points를 가진다.")
    void createOfUser() {
        Line line = new Line(3);
        assertThat(line.getPoints().size()).isEqualTo(3);
    }
}
