package ladder;

import ladder.domain.Answers;
import ladder.domain.Location;
import ladder.domain.Players;
import ladder.exception.ResultException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ResultTest {

    @Test
    @DisplayName("결과 입력")
    void inputResult() {
        assertDoesNotThrow(() -> Answers.of("꽝,1000,꽝,5000", Players.of("p1,p2,p3,p4")));
    }

    @Test
    @DisplayName("결과가 존재하지 않으면 에러")
    void noneResult() {
        Answers answers = Answers.of("result1, result2", Players.of("p1, p2"));
        Assertions.assertThatThrownBy(() -> answers.getResult(new Location(3))).isInstanceOf(ResultException.class);
    }
}
