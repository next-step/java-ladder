package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

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

        Ladder ladder = new Ladder(ladderRows);
        assertThat(ladder).isEqualTo(new Ladder(ladderRows));
    }
}
