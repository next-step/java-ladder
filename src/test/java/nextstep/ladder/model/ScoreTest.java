package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    private final Player player = Player.from("chomi");

    @DisplayName("플레이어와 숫자를 이용해 Score를 생성")
    @Test
    void creatScoreWithPlayerAndInteger() {
        assertThatNoException().isThrownBy(() -> Score.of(player, 1));
    }

    @DisplayName("점수를 1점씩 올릴 수 있습니다.")
    @Test
    void canAddSCore() {
        Score score = Score.of(player, 1);
        Score addedScore = score.addSCore();
        assertThat(addedScore.intScore()).isEqualTo(2);
    }

    @DisplayName("점수를 1점씩 내릴 수 있습니다.")
    @Test
    void canMinusScore() {
        Score score = Score.of(player, 3);
        Score minusedScore = score.minusScore();
        assertThat(minusedScore.intScore()).isEqualTo(2);
    }

}
