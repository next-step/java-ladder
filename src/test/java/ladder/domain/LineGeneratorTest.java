package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    private LineGenerator lineGenerator;

    @DisplayName("라인을 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void generate(int playerCount) {
        lineGenerator = new LineGenerator(playerCount);
        List<Boolean> lines = lineGenerator.generate();

        assertThat(lines.size()).isEqualTo(playerCount);
    }

    @DisplayName("처음 위치엔 라인을 생성할 수 없다.")
    @Test
    void generateStartLine() {
        lineGenerator = new LineGenerator(1);
        List<Boolean> lines = lineGenerator.generate();

        assertThat(lines.get(0)).isFalse();
    }
}