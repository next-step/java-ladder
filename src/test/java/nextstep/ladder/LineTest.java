package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {
    @Test
    @DisplayName("중복되는 가로선이 없는지 출력 확인")
    void check() {
        Line line = new Line(6);
        System.out.println(line);
    }
}
