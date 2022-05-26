package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    void createLinesUpToHeight() {
        // given
        int width = 2, height = 3;
        // when
        Lines lines = Lines.create(width, height);
        // then
        assertThat(lines.lines()).hasSize(3);
    }

//    @Test
//    void assertManual() {
//        Lines lines = new Lines(Arrays.asList(
//                new Line(Arrays.asList(true, false, true)),
//                new Line(Arrays.asList(false, true, false))
//        ));
//    }
}
