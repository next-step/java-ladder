package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ladder.domain.lineGenerator.DefaultLineGeneratorTest;

public class LadderTest {
    @Test
    public void 생성() {
        List<Line> lines = new ArrayList<>();
        lines.add(DefaultLineGeneratorTest.createLine());
        lines.add(DefaultLineGeneratorTest.createLine());
        assertThat(Ladder.of(lines).getLines()).contains(DefaultLineGeneratorTest.createLine());
    }
}
