package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowsTest {

    @Test
    void 생성() {
        List<LadderRow> ladderRowList =
                Arrays.asList(
                        new LadderRow(
                                Arrays.asList(
                                        new Link(true),
                                        new Link(true),
                                        new Link(true)
                                )
                        ),
                        new LadderRow(
                                Arrays.asList(
                                        new Link(true),
                                        new Link(true),
                                        new Link(true)
                                )
                        ),
                        new LadderRow(
                                Arrays.asList(
                                        new Link(true),
                                        new Link(true),
                                        new Link(true)
                                )
                        )
                );
        LadderRows ladderRows = new LadderRows(ladderRowList);
        assertThat(ladderRows).isEqualTo(new LadderRows(ladderRowList));
    }
}
