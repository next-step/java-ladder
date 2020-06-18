package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatCode;

class GameResultTest {
    @Test
    @DisplayName("생성 테스트")
    void valueOf() {
        Map<Person, Result> gameResult = Map.of(Person.of("ej"), Result.of("당첨!"));
        assertThatCode(() -> GameResult.valueOf(gameResult)).doesNotThrowAnyException();
    }
}
