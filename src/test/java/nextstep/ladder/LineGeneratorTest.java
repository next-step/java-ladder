package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineGeneratorTest {

    @Test
    void create() {
        List<Boolean> line = LineGenerator.createLine(4);
        assertThat(line).hasSize(4);
    }

}