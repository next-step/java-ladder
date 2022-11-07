package ladder.domain;

import ladder.strategy.RandomLineCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @DisplayName("라인 생성 성공")
    void create_line_test(int countOfMembers) {
        LadderLine ladderLine = new LadderLine(countOfMembers, new RandomLineCreateStrategy());
        assertThat(ladderLine).isNotNull();
    }

    @Test
    @DisplayName("사다리 생성시 사다리 라인의 한 part 의 값이 true 가 되면 그 왼쪽은 반드시 false 이다.")
    void test() {
        LadderLine ladderLine = new LadderLine(4, new RandomLineCreateStrategy());
        List<Boolean> parts = ladderLine.parts();
        parts.stream()
                .filter(part -> part)
                .forEach(part -> {
                    assertThat(parts.get(parts.indexOf(true) - 1)).isFalse();
                });
    }
}
