package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {


    @DisplayName("사다리 가로라인이 겹쳐지는 경우 Exception Test")
    @Test
    void linePointsDuplicationTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<Point> points = new ArrayList<>();
            points.add(new Point(Direction.of(false, true)));
            points.add(new Point(Direction.of(true, true)));

            new Line(points);

        }).withMessageContaining("사다리 가로라인은 겹칠 수 없습니다.");
    }
}
