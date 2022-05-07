package ladder.domain;

import ladder.exception.InvalidNameOfReulstException;
import ladder.exception.InvalidNumberOfResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {
    Participants participants;

    @BeforeEach
    void 참가자_초기화() {
        participants = new Participants("A,B,C");
    }

    @Test
    void 참가자_수와_실행결과_수가_다른_경우_테스트() {
        assertThatThrownBy(() -> new GameResult("꽝,3000,꽝,4000", participants))
                .isInstanceOf(InvalidNumberOfResultException.class);
    }

    @Test
    void 유효하지_않은_실행결과_입력_테스트() {
        assertThatThrownBy(() -> new GameResult(",3000,꽝", participants))
                .isInstanceOf(InvalidNameOfReulstException.class);
    }
}