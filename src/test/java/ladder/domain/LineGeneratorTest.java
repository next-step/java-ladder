package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    private LineGenerator lineGenerator;

    @BeforeEach
    void setUp() {
        lineGenerator = new LineGenerator();
    }

    @DisplayName("라인을 생성할 수 있다.")
    @Test
    void generateLine() {
        int playerCount = 2;
        List<Boolean> lines = lineGenerator.generate(playerCount);

        assertThat(lines.size()).isEqualTo(2);
    }
}