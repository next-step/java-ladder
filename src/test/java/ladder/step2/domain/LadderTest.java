package ladder.step2.domain;

import ladder.step2.domain.partlinestrategy.RandomPartLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static final Ladder LADDER = Ladder.of(3, 5, () -> PartLineTest.TRUE);
    
    @Test
    @DisplayName("모든 플레이어 사다리 결과")
    void move() {
        List<Integer> ladderGameResult = LADDER.move(new Players(Arrays.asList("honux", "jun", "jk", "pobi", "young")));
        assertThat(ladderGameResult).isEqualTo(Arrays.asList(1, 0, 3, 2, 4));
    }
}
