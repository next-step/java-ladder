package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.strategy.Strategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    @DisplayName("높이만큼 라인을 생성한다")
    void shouldCreate(int height) {
        Lines lines = Lines.from(height, 3, new Strategy.Fake());
        assertThat(lines.size()).isEqualTo(height);
    }
}