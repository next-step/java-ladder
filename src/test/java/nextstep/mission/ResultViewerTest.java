package nextstep.mission;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewerTest {

    @Test
    void lineToWrite() {
        assertThat(ResultViewer.lineToWrite(new Line(Arrays.asList(true, false, true, false)))).isEqualTo("-----|     |-----|     |");
    }
}
