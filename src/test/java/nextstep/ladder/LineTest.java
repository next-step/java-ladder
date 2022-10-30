package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 전좌표가_true일_경우() {
        List<Boolean> bool = new ArrayList<>();
        bool.add(true);
        Line line = new Line(bool);

        line.addPoint(1);

        assertThat(line.getPoint(1)).isFalse();
    }
}
