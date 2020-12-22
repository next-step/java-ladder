package ladder.domain.next;

import ladder.domain.LadderTest;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

class NextLadderTest extends LadderTest {

    @BeforeEach
    void setUp() {
        List<LadderLine> lines = Arrays.asList(
                LadderLine.builder().first(true).next(false).last().build(),
                LadderLine.builder().first(false).next(true).last().build(),
                LadderLine.builder().first(false).next(false).last().build(),
                LadderLine.builder().first(true).next(false).last().build(),
                LadderLine.builder().first(false).next(true).last().build()
        );

        ladder = new NextLadder(
                members,
                results,
                lines
        );
    }

}
