package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.LadderHeightException;
import step2.exception.ValidPlayerCountException;
import step2.hint.CreateLadderPointGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    @DisplayName("사다리 높이가 0일경우 익셉션 발생")
    void throwLadderHeightException() {
        assertThatThrownBy(() -> Ladder.of(0, 1, new CreateLadderPointGenerator()))
                .isInstanceOf(LadderHeightException.class);
    }

    @Test
    @DisplayName("리워드의 숫자와 플레이어의 숫자가 일치하지 않을경우 익셉션 발생")
    void throwPlayerRewardsCountException() {
        assertThatThrownBy(() -> Ladder.of(1, 0, new CreateLadderPointGenerator()))
                .isInstanceOf(ValidPlayerCountException.class);
    }

    @Test
    @DisplayName("Ladder가 잘 생성되는지 확인한다.")
    void create() {
        Ladder ladder = Ladder.of(3, 3, new CreateLadderPointGenerator());

        assertThat(ladder).usingRecursiveComparison()
                .isEqualTo(Ladder.of(3, 3, new CreateLadderPointGenerator()));
    }

}