package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameTest {
    @Test
    @DisplayName("사람 수와 결과 수는 다를 수 없다")
    public void countOfPersonDifferentWithCountOfPrize() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(
                        5,
                        List.of("pobi", "honux", "crong", "jk"),
                        List.of("꽝", "5000", "꽝"),
                        new RandomAmongAllNonAdjacentCombinationLineStrategy()
                ));
    }

    @Test
    @DisplayName("입력받은 사람의 결과를 계산한다")
    public void calculatePrize() {
        LadderGame ladderGame = new LadderGame(
                5,
                List.of("pobi", "honux", "crong", "jk"),
                List.of("꽝", "1000", "2000", "3000"),
                new NoLineStrategy()
        );
        assertAll(
                () -> assertThat(ladderGame.calculatePrize("pobi")).isEqualTo("꽝"),
                () -> assertThat(ladderGame.calculatePrize("honux")).isEqualTo("1000"),
                () -> assertThat(ladderGame.calculatePrize("crong")).isEqualTo("2000"),
                () -> assertThat(ladderGame.calculatePrize("jk")).isEqualTo("3000")
        );
    }
}