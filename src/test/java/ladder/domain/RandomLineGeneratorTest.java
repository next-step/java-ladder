package ladder.domain;

import ladder.domain.generator.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineGeneratorTest {
    @DisplayName("라인을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void generate(int playerCount) {
        List<Boolean> lines = new RandomLineGenerator().generate(playerCount);

        assertThat(lines.size()).isEqualTo(playerCount);
    }

    @DisplayName("처음 위치엔 라인을 생성할 수 없다.")
    @Test
    void generateStartLine() {
        int playerCount = 1;

        List<Boolean> lines = new RandomLineGenerator().generate(playerCount);

        assertThat(lines.get(0)).isFalse();
    }
}