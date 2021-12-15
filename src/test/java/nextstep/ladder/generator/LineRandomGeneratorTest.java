package nextstep.ladder.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineRandomGeneratorTest {

    @Test
    @DisplayName("이전 값이 TRUE 일 경우, 무조건 FALSE")
    void beforeTrueThenFalse() {

        LineRandomGenerator generator = new LineRandomGenerator();
        boolean result = generator.generate(Boolean.TRUE);

        assertThat(result).isFalse();

    }
}