package ladder.domain.ladderline;

import ladder.RandomTestUtils;
import ladder.common.PositiveNumber;
import ladder.domain.DefaultLadderLineFactory;
import ladder.domain.LadderLineFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLinesTest {

    @Test
    @DisplayName("사다리 높이를 정상적으로 생성하는지 확인한다")
    void checkLadderHeight() {
        LadderLineFactory ladderLineFactory = new DefaultLadderLineFactory(RandomTestUtils.TRUE);
        LadderLines ladderLines = ladderLineFactory.create(PositiveNumber.of(5), PositiveNumber.of(5));
        assertThat(ladderLines.get().size()).isEqualTo(5);
    }
}
