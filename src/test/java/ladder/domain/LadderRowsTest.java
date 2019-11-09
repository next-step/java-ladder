package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowsTest {

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

        List<LadderRow> ladderRowList =
                Arrays.asList(
                        new LadderRow(new Lines(lines), new Links(links)),
                        new LadderRow(new Lines(lines), new Links(links)),
                        new LadderRow(new Lines(lines), new Links(links))
                );

        LadderRows ladderRows = new LadderRows(ladderRowList);
        assertThat(ladderRows).isEqualTo(new LadderRows(ladderRowList));
    }
}
