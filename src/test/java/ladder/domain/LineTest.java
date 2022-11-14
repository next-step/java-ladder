package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LineTest {

    @Test
    void linkSize_0() {
        Line line = new Line(List.of(false, false));
        assertThat(line.linkSize()).isEqualTo(0);
    }

    @Test
    void linkSize_1() {
        Line line = new Line(List.of(false, true));
        assertThat(line.linkSize()).isEqualTo(1);
    }

    @Test
    void linkSize_2() {
        Line line = new Line(List.of(false, true, false, true));
        assertThat(line.linkSize()).isEqualTo(2);
    }

    @Test
    void invalid_firstPoint() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(List.of(true, false)));
    }

    @Test
    void invalid_Link() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(List.of(false, true, true)));
    }

    @Test
    void line_of_countOfPerson() {
        Line line = Line.of(4);
        System.out.println(line);
        assertThat(line.size()).isEqualTo(4);
    }
}
