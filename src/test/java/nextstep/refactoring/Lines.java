package nextstep.refactoring;

import nextstep.ladder.TrueGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinesTest {
    @Test
    void create() {
        Lines lines = new Lines(5, 4, new TrueGenerator());
        Assertions.assertThat(lines).isNotNull();
    }

    @Test
    void move() {
        /**
         * |-| |-|
         * |-| |-|
         * |-| |-|
         * |-| |-|
         * |-| |-|
         */
        Lines lines = new Lines(5, 4, new TrueGenerator());
        Assertions.assertThat(lines.move(0)).isEqualTo(1);
    }


}
