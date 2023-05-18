package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @Test
    @DisplayName("사용자 수와 사용자의 실행결과가 다를 때 예외 throw")
    void validate() {
        String inputPlayers = "pobi,java";
        String inputResults = "꽝,5000,꽝";
        Players players = Players.from(inputPlayers);
        assertThatThrownBy(() -> Results.from(inputResults, players.size()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}