package domain;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class LineTest {

    @Test(expected = RuntimeException.class)
    public void Line생성자잘못() {
        List<Boolean> booleanList = Arrays.asList(true, false, true, true);
        Line line = new Line(booleanList);
    }

    @Test
    public void Line생성자() {
        List<Boolean> booleanList = Arrays.asList(true, false, true, false);
        Line line = new Line(booleanList);
        assertThat(line.toString()).isEqualTo("|-----|     |-----|     |");
    }
}