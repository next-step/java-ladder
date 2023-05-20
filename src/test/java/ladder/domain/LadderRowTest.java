package ladder.domain;

import ladder.strategy.LineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderRowTest {
    private LineStrategy lineStrategyTrue = () -> true;

    @Test
    @DisplayName("주어진 width 만큼의 line을 생성한다")
    void 라인_생성() {
        LadderRow ladderRow = new LadderRow(3);
        assertThat(ladderRow.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("연달아 라인을 생성하지 않는다.")
    void 중복생성_방지() {
        LadderRow ladderRow = new LadderRow(3, lineStrategyTrue);
        List<Boolean> expected = new ArrayList<>(Arrays.asList(true, false, true));
        assertThat(ladderRow.isEqualTo(expected)).isTrue();
    }
}
