package ladder.domain.result;

import ladder.domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderResultsTest {

    @Test
    @DisplayName("참가자 숫자와 사다리 결과 값의 길이가 다르면 예외 발생")
    void throwExceptionWhenDifferentSize() {
        Players players = Players.of("aaa,bbb,ccc");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LadderResults.of("10,20", players);
        }).withMessageMatching("Participants and results have different sizes.");
    }
}
