package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowTest {

    @Test
    void 생성() {
        List<Line> lines = Arrays.asList(
                new Line(),
                new Line(),
                new Line()
        );
        List<Link> links = Arrays.asList(
                new Link(true),
                new Link(true),
                new Link(true)
        );
        LadderRow ladderRow = new LadderRow(new Lines(lines), new Links(links));
        assertThat(ladderRow).isEqualTo(new LadderRow(new Lines(lines), new Links(links)));
    }
}
