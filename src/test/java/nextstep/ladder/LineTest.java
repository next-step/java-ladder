package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("중복되는 가로선이 없는지 출력 확인")
    void check() {
        Line line = new Line(6);
        System.out.println(line);
    }

    @Test
    @DisplayName("생성된 Point 사이즈 확인")
    void size() {
        Line line = new Line(6);
        assertThat(line.getPoints()).hasSize(5);
    }
}
