package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {
    private List<Boolean> lines = Arrays.asList(true, true, false, false);

    @Test
    void createLine() {
        Line line = new Line(4, c -> lines.subList(0, c));
        assertThat(line.getPoints()).contains(true, true, false, false);
    }

    @Test
    void createLineTrueTrue() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Line(3, c->Arrays.asList(true,true,true)));
    }


    @Test
    void getSize() {
        Line line = new Line(4, c -> lines.subList(0, c));
        assertThat(line.getPoints().size()).isEqualTo(4);
    }
}