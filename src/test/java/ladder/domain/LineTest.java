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
        assertThatCode(() -> Line.valueOf(countOfPerson)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이 전 값이 true이면 false를 반환한다")
    void checkLineOverlap() {
        Line line = Line.valueOf(countOfPerson);
        Random random = new Random();
        boolean point = line.checkLineOverlap(true, random);

        assertThat(point).isFalse();
    }

}
