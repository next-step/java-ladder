package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
    @Test
    @DisplayName("높이는 1 미만일 수 없다")
    public void invalidHeight() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(0, 4, new RandomAmongAllNonAdjacentCombinationLineStrategy()));
    }

    @Test
    @DisplayName("사다리 실행")
    public void execute() {
        Ladder ladder = new Ladder(5, 4, new NoLineStrategy());
        assertAll(
                () -> assertThat(ladder.execute(0)).isEqualTo(0),
                () -> assertThat(ladder.execute(1)).isEqualTo(1),
                () -> assertThat(ladder.execute(2)).isEqualTo(2),
                () -> assertThat(ladder.execute(3)).isEqualTo(3)
        );
    }
}
