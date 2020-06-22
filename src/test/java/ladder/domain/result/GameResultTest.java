package ladder.domain.result;

import ladder.domain.participants.Person;
import ladder.domain.result.GameResult;
import ladder.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class GameResultTest {
    @Test
    @DisplayName("생성 테스트")
    void valueOf() {
        Map<Person, Result> gameResult = Map.of(Person.of("ej"), Result.of("당첨!"));
        assertThatCode(() -> GameResult.valueOf(gameResult)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참가자의 결과를 출력한다")
    void findResult(){
        Map<Person, Result> result = Map.of(Person.of("ej"), Result.of("당첨!"));
        GameResult gameResult = GameResult.valueOf(result);

        assertThat(gameResult.findResult("ej")).isEqualTo("당첨!");
        assertThat(gameResult.findResult("pobi")).isEqualTo("없는 참가자 입니다.");
    }
}
