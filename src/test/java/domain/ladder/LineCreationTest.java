package domain.ladder;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class LineCreationTest {

    @Test
    public void 라인개수() {
        List<Line> lines = new LineCreation().getLines(4, 5);
        assertThat(lines).hasSize(4);
    }
}