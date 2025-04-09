
import domain.Line;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 라인이_사람수_기준으로_생성되는지_확인() {
        int countOfPoints = 3;
        Line line = new Line(countOfPoints);
        assertNotNull(line);
    }
}