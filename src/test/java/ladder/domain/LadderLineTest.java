package ladder.domain;

import ladder.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    @DisplayName("라인 생성 성공")
    void create_line_test(int countOfMembers) {
        LadderLine ladderLine = new LadderLine(countOfMembers, new RandomLineCreateStrategy());
        assertThat(ladderLine).isNotNull();
    }
}
