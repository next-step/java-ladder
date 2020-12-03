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
        assertThatThrownBy(() -> new Ladder.LadderBuilder()
                .buildLadderHeight(0)
                .buildPlayerCount(1)
                .buildLadderPointGenerator(new CreateLadderPointGenerator())
                .build())
                .isInstanceOf(LadderHeightException.class);
    }

    @Test
    @DisplayName("플레이어의 숫자가 0이하일 경우 익셉션 발생")
    void throwPlayerRewardsCountException() {
        assertThatThrownBy(() -> new Ladder.LadderBuilder()
                .buildLadderHeight(1)
                .buildPlayerCount(0)
                .buildLadderPointGenerator(new CreateLadderPointGenerator())
                .build())
                .isInstanceOf(ValidPlayerCountException.class);
    }

    @Test
    @DisplayName("Ladder가 잘 생성되는지 확인한다.")
    void create() {
        Ladder ladder = new Ladder.LadderBuilder()
                .buildLadderHeight(1)
                .buildPlayerCount(2)
                .buildLadderPointGenerator(new CreateLadderPointGenerator())
                .build();

        assertThat(ladder).usingRecursiveComparison()
                .isEqualTo(new Ladder.LadderBuilder()
                        .buildLadderHeight(1)
                        .buildPlayerCount(2)
                        .buildLadderPointGenerator(new CreateLadderPointGenerator())
                        .build());
    }

}