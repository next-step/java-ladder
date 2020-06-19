package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LineTest {
    int countOfPerson = 3;

    @Test
    @DisplayName("생성 테스트")
    void create() {
        Random random = new Random();
        assertThatCode(() -> Line.valueOf(countOfPerson, random::nextBoolean))
                .doesNotThrowAnyException();
    }

}
