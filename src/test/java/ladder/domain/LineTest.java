package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {

    @Test
    @DisplayName("라인 생성시 사람수가 2보다 작으면 IllegalArgumentException이 발생한다.")
    void personCountException() {
        int personCount = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Line(personCount, () -> true))
                .withMessage("사다리 게임에 참여하는 사람 수가 너무 작습니다. 사람 수 : " + personCount);
    }

}