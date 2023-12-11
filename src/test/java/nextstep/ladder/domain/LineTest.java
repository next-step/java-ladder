package nextstep.ladder.domain;

import nextstep.ladder.utils.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LineTest {
    @Test
    @DisplayName("같은 라인에 연속으로 설정되는 경우 Exception Throw")
    void line_연속생성불가_Test() {
        Line line = new Line(3);
        System.out.println("line = " + line);
    }
}
