package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LineGeneratorTest {

    @Test
    void generate() {
        LineGenerator generator = () -> true;
        Assertions.assertThat(generator.generate()).isTrue();
    }
}