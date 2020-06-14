package ladder.domain;

import ladder.domain.Line;
import ladder.domain.Linetype;
import ladder.domain.OnePossibilityStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    Line line;

    @BeforeEach
    void setUp() {
        line = new Line();
    }

    @Test
    void initLineTest() {
        assertThat(line.getClass().getSimpleName()).isEqualTo("Line");
    }

    @Test
    void initLineTypeListTest() {
        List<Linetype> lineTypeList = new ArrayList<>(List.of(Linetype.VERTICAL, Linetype.BLANK, Linetype.HORIZONTAL));
        Line line = new Line(lineTypeList);
        assertThat(line.getLineTypes()).containsAll(lineTypeList);
    }

    @Test
    void makeVerticalTypeTest() {
        Linetype linetype = line.makeType(0);
        assertThat(Linetype.VERTICAL.getLine()).isEqualTo(linetype.getLine());
    }

    @Test
    void getHorizontalTypeTest() {
        Linetype linetype = line.getHorizontalType(new OnePossibilityStrategy());
        assertThat(Linetype.HORIZONTAL.getLine()).isEqualTo(linetype.getLine());
    }
}
