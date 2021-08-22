package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {

    @Test
    @DisplayName("라인 생성시 사람수가 2보다 작으면 IllegalArgumentException이 발생한다.")
    void personCountException() {
        int personCount = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(personCount, () -> true))
                .withMessage("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + personCount);
    }

    @Test
    @DisplayName("라인 생성 시 라인이 연속으로 겹치지 않는다.")
    void constructor() {
        int personCount = 5;
        Line line = new Line(personCount, () -> new Random().nextBoolean());
        assertTrue(IntStream.range(1, personCount)
                .allMatch(idx -> !(line.lineExists(idx - 1) && line.lineExists(idx))));
    }

}