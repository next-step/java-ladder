package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    Line line;
    List<LineType> lineTypeList;

    @BeforeEach
    void setUp() {
        lineTypeList = new ArrayList<>(List.of(LineType.VERTICAL, LineType.BLANK, LineType.VERTICAL, LineType.HORIZONTAL));
        line = new Line(lineTypeList);
    }

    @Test
    void initLineTest() {
        assertThat(line.getClass().getSimpleName()).isEqualTo("Line");
    }

    @Test
    void initLineTypeListTest() {
        assertThat(line.getLineTypes()).containsAll(lineTypeList);
    }

    @Test
    void checkPrePointTest() {
        assertThat(line.checkPrePoint(3)).isEqualTo(false);
    }

}
